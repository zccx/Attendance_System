// sql语句
var sqlMap = {
  // 用户
  user: {
    add: 'insert into user(id, name, age) values (2, ?, ?)'
  },
  student:{
    add:'insert into student(id,username,password,sno,sex,school,academy,major,grade,remark,mail,phone,name) values (0,?,?,?,?,?,?,?,?,?,?,?,?)',
    select_username:'SELECT * from student where username=? ',
    select_course:'SELECT * from course_stu where sno=?',
    add_qingjia:'insert into qingjia(id,name,sno,course,cno,qjday,reason,isapproval) values (0,?,?,?,?,?,?,?)'
  },
  teacher:{
    select_username:'SELECT * from teacher where username=? ',
    select_course:'SELECT * from course where tno=? ',
    select_qingjia:'SELECT * from qingjia where cno=? and isapproval=?'
  }
}

module.exports = sqlMap;
