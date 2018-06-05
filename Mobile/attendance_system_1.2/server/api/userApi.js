var models = require('../db');
var express = require('express');
var router = express.Router();
var mysql = require('mysql');
var $sql = require('../sqlMap');

// 连接数据库
var conn = mysql.createConnection(models.mysql);

conn.connect();
var jsonWrite = function(res, ret) {
  if(typeof ret === 'undefined') {
    res.json({
      code: '1',
      msg: '操作失败'
    });
  } else {
    res.json(ret);
  }
};
router.post('/addQingjia',(req,res)=>{
  var sql=$sql.student.add_qingjia;
  var params=req.body;
  conn.query(sql,[params.name,params.sno,params.course,params.cno,params.qjday,params.reason,params.isapproval],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/selectCourse_t',(req,res)=>{
  var sql_tno=$sql.teacher.select_course;
  var params=req.body;
  console.log(params)
  conn.query(sql_tno,params.tno,function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})

router.post('/addStudent', (req, res) => {
  var sql = $sql.student.add;
  var sql_username=$sql.student.select_username;
  var params = req.body;
  console.log(params);
  conn.query(sql_username,params.username,function (err,result) {
    if (err) {
      console.log(err);
    }
    if (result[0]===undefined) {
      conn.query(sql, [params.username, params.password,params.sno,params.sex,params.school,params.academy,params.major,params.grade,params.remark,params.mail,params.phone,params.name], function(err, result) {
        if (err) {
          console.log(err);
        }
        if(result) {
          jsonWrite(res, result)
        }
      })
    }else {
      res.send('-1')    //当前注册username与数据库重复时，data返回-1
    }
  })
});
router.post('/selectQingjia',(req,res)=>{
  var sql=$sql.teacher.select_qingjia;
  var params=req.body;
  conn.query(sql,[params.cno,params.isapproval],function (err,result) {
    if(err){
      console.log(err);
    }
    else {
      jsonWrite(res,result);
    }
  })
})
router.post('/selectStudent',(req,res)=>{
  var sql_username=$sql.student.select_username;
  var params = req.body;
  console.log(params);
  conn.query(sql_username,params.username,function (err,result) {
    if (err) {
      console.log(err);
    }
    if (result[0]===undefined) {

     res.send('-1')
    }else if(result[0].password!=params.password){
      res.send('0')
    }else{
      jsonWrite(res, result);
    }
  })
})
router.post('/selectCourse',(req,res)=>{
  var sql_sno=$sql.student.select_course;
  var params = req.body;
  console.log(params);
  conn.query(sql_sno,params.sno,function (err,result) {
    if (err) {
      console.log(err);
    }
    if (result[0]===undefined) {
      res.send('-1')
    }else{
      var i=0
      while(i<result.length) {
        switch (result[i].weekday) {
          case 0:
            result[i].weekday='星期天';
            break;
          case 1:
            result[i].weekday='星期一';
            break;
          case 2:
            result[i].weekday='星期二';
            break;
          case 3:
            result[i].weekday='星期三';
            break;
          case 4:
            result[i].weekday='星期四';
            break;
          case 5:
            result[i].weekday='星期五';
            break;
          case 6:
            result[i].weekday='星期六';
            break;
        }
        i=i+1;
      }
      jsonWrite(res, result);
    }
  })
})
router.post('/selectTeacher',(req,res)=>{
  var sql_username=$sql.teacher.select_username;
  var params = req.body;
  console.log(params);
  conn.query(sql_username,params.username,function (err,result) {
    if (err) {
      console.log(err);
    }
    if (result[0]===undefined) {

      res.send('-1');
    }else if(result[0].password!=params.password){
      res.send('0')
    }else{
      jsonWrite(res, result);
    }
  })
})
module.exports = router;
