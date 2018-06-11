// sql语句
var sqlMap = {
  // 用户
  user: {
    add: 'insert into user(id, name, age) values (2, ?, ?)'
  },
  student:{
    add:'insert into student(id,username,password,sno,phone) values (0,?,?,?,?)',
    add_record:'insert into record(id,sno,name,classroom,course,cno,row,col,date,time) values (0,?,?,?,?,?,?,?,?,?)',
    update:'update student set name=?,sex=?,mail=?,school=?,academy=?,major=?,grade=?,remark=? where sno=?',
    update_pwd:'update student set password=? where username=?',
    select_username:'SELECT * from student where username=? ',
    select_course:'SELECT * from course_stu where sno=?',
    select_record:'SELECT * from record where cno=? and row=? and col=? and date=?',
    select_record_1:'SELECT * from record where sno=?',
    select_course_1:'SELECT * from course where cno=?',
    select_studnet:'SELECT * from student where sno=?',
    select_classroom:'SELECT * from classroom where classroom=?',
    add_qingjia:'insert into qingjia(id,name,sno,course,cno,qjday,reason,isapproval) values (0,?,?,?,?,?,?,?)'
  },
  teacher:{
    update:'update teacher set phone=?,sex=?,mail=?,school=?,academy=?,remark=? where tno=?',
    update_qj:'update qingjia set isapproval=true,ispass=?,refuse=? where id=?',
    select_username:'SELECT * from teacher where username=? ',
    select_stu:'SELECT * from course_stu where cno=?',
    select_course:'SELECT * from course where tno=? ',
    select_qingjia:'SELECT * from qingjia where cno=? and isapproval=?'
  }
}

module.exports = sqlMap;
