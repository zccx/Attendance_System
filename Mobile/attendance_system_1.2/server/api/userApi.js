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
router.post('/update_pwd',(req,res)=>{
  var sql=$sql.student.update_pwd;
  var params=req.body;
  conn.query(sql,[params.password,params.username],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/selectRe',(req,res)=>{
  var sql=$sql.student.select_record;
  var sql_1=$sql.student.select_record_2;
  var params=req.body;
  conn.query(sql_1,[params.sno,params.cno,params.date],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result[0]!=undefined) {
      res.send('已经签到过')
    }else{
      conn.query(sql,[params.cno,params.row,params.col,
        params.date],function (err,result){
        if (err) {
          console.log(err);
        }
        if(result[0]!=undefined) {
          res.send('该座位已经有人')
        }else{
          jsonWrite(res, result)
        }
      })
    }
  })
})
router.post('/selectRecord',(req,res)=>{
  var sql=$sql.student.select_record_1;
  var params=req.body;
  conn.query(sql,params.sno,function (err,result){
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/addRecord',(req,res)=>{
  var sql=$sql.student.add_record;
  var params=req.body;
  conn.query(sql,[params.sno,params.name,params.classroom, params.course,
                  params.cno,params.row,params.col,
                  params.date,params.time],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {

      jsonWrite(res, result)
    }
  })
})
router.post('/update_qj',(req,res)=>{
  var sql=$sql.teacher.update_qj;
  var params=req.body;
  conn.query(sql,[params.ispass,params.refuse,params.id],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/select_stu',(req,res)=>{
  var sql=$sql.teacher.select_stu;
  var params=req.body;
  conn.query(sql,params.cno,function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/select_record',(req,res)=>{
  var sql=$sql.teacher.select_record;
  var params=req.body;
  conn.query(sql,[params.cno,params.date],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/select_student',(req,res)=>{
  var sql=$sql.student.select_student;
  var params=req.body;
  conn.query(sql,params.sno,function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/selectClassroom',(req,res)=>{
  var sql=$sql.student.select_classroom;
  var params=req.body;
  console.log(params)
  conn.query(sql,params.classroom,function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/updateStudent',(req,res)=>{
  var sql=$sql.student.update;
  var params=req.body;
  conn.query(sql,
    [params.name,
      params.sex,
      params.mail,
      params.school,
      params.academy,
      params.major,
      params.grade,
      params.remark,
      params.sno],function (err,result) {
      if (err) {
        console.log(err);
      }
      if(result) {
        jsonWrite(res, result)
      }
    })
})
router.post('/updateTeacher',(req,res)=>{
  var sql=$sql.teacher.update;
  var params=req.body;
  conn.query(sql,
    [params.phone,
      params.sex,
      params.mail,
      params.school,
      params.academy,
      params.remark,
      params.tno],function (err,result) {
      if (err) {
        console.log(err);
      }
      if(result) {
        jsonWrite(res, result)
      }
    })
})
router.post('/select_xx',(req,res)=>{
  var sql=$sql.student.select_xx
  var params=req.body;
  conn.query(sql,[params.sno,params.isapproval,params.isread],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/select_Xx1',(req,res)=>{
  var sql=$sql.student.select_Xx1
  var params=req.body;
  conn.query(sql,[params.sno,params.isapproval],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/select_detail',(req,res)=>{
  var sql=$sql.student.select_detail
  var params=req.body;
  conn.query(sql,params.id,function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/add_release',(req,res)=>{
  var sql=$sql.teacher.add_release
  var sql_sel=$sql.teacher.select_rel
  var params=req.body;
  console.log(sql)
  conn.query(sql_sel,[params.cno,params.date],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result[0]==undefined){
      conn.query(sql,[params.cno,params.course,params.tno,params.stime1,params.stime2,params.etime1,params.etime2,params.date],function (err,result) {
        if (err) {
          console.log(err);
        }
        if(result) {
          jsonWrite(res, result)
        }
      })
    }else{
      res.send('-1')
    }
  })
})
router.post('/select_rel',(req,res)=>{
  var sql=$sql.teacher.select_rel
  var params=req.body;
  console.log(params)
  conn.query(sql,[params.cno,params.date],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result[0]!=undefined) {
      jsonWrite(res, result)
    }else{
      res.send('-1')
    }
  })
})
router.post('/update_qj1',(req,res)=>{
  var sql=$sql.student.update_qj
  var params=req.body;
  console.log(params)
  conn.query(sql,[params.isread,params.id],function (err,result) {
    if (err) {
      console.log(err);
    }
    if(result) {
      jsonWrite(res, result)
    }
  })
})
router.post('/addQingjia',(req,res)=>{
  var sql=$sql.student.add_qingjia;
  var params=req.body;
  conn.query(sql,
    [params.name,
    params.sno,
    params.course,
    params.cno,
    params.qjday,
    params.reason,
    params.isapproval,
    params.isread],function (err,result) {
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
    if (result[0]===undefined) {
      res.send('-1')
    }else{
      var i=0
      while(i<result.length) {
        switch (result[i].weekday) {
          case '0':
            result[i].weekday='星期天';
            break;
          case '1':
            result[i].weekday='星期一';
            break;
          case '2':
            result[i].weekday='星期二';
            break;
          case '3':
            result[i].weekday='星期三';
            break;
          case '4':
            result[i].weekday='星期四';
            break;
          case '5':
            result[i].weekday='星期五';
            break;
          case '6':
            result[i].weekday='星期六';
            break;
        }
        i=i+1;
      }
      jsonWrite(res, result);
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
      conn.query(sql, [params.username, params.password,params.sno,params.phone], function(err, result) {
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
    else if(result[0]===undefined){
        res.send("无")
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
    }else {
      jsonWrite(res, result);
    }
  })
})
router.post('/select_rel_tno',(req,res)=>{
  var sql=$sql.teacher.select_rel_tno;
  var params = req.body;
  console.log(params);
  conn.query(sql,params.tno,function (err,result) {
    if (err) {
      console.log(err);
    }
  else{
      jsonWrite(res, result);
    }
  })
})
router.post('/select_qj',(req,res)=>{
  var sql=$sql.teacher.select_qj;
  var params = req.body;
  console.log(params);
  conn.query(sql,[params.cno,params.date],function (err,result) {
    if (err) {
      console.log(err);
    }
    else{
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
      jsonWrite(res, result);
    }
  })
})
router.post('/selectCourse_1',(req,res)=>{
  var sql_sno=$sql.student.select_course_1;
  var params = req.body;
  console.log(params);
  conn.query(sql_sno,params.cno,function (err,result) {
    if (err) {
      console.log(err);
    }
    if (result[0]===undefined) {
      res.send('-1')
    }else{
      var i=0
      while(i<result.length) {
        switch (result[i].weekday) {
          case '0':
            result[i].weekday='星期天';
            break;
          case '1':
            result[i].weekday='星期一';
            break;
          case '2':
            result[i].weekday='星期二';
            break;
          case '3':
            result[i].weekday='星期三';
            break;
          case '4':
            result[i].weekday='星期四';
            break;
          case '5':
            result[i].weekday='星期五';
            break;
          case '6':
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
    }else{
      jsonWrite(res, result);
    }
  })
})
module.exports = router;
