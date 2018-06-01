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
router.post('/selectTeacher',(req,res)=>{
  var sql_username=$sql.teacher.select_username;
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
module.exports = router;
