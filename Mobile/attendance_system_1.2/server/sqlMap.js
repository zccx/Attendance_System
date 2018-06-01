// sql语句
var sqlMap = {
  // 用户
  user: {
    add: 'insert into user(id, name, age) values (2, ?, ?)'
  },
  student:{
    add:'insert into student(id,username,password,sno,sex,school,academy,major,grade,remark,mail,phone,name) values (0,?,?,?,?,?,?,?,?,?,?,?,?)',
    select_username:'SELECT * from student where username=? ',
  },
  teacher:{
    select_username:'SELECT * from teacher where username=? ',
  }
}

module.exports = sqlMap;
