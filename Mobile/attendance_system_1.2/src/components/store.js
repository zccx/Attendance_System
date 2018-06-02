var key = 'user'

export default {
  fetch: function(key) {
    return window.JSON.parse(window.localStorage.getItem(key) || '[]')

  },

  save: function(key,items) {
    window.localStorage.setItem(key, window.JSON.stringify(items))
  }

}

// import 'rxjs/add/operator/map';
//
//
// /*
//   Generated class for the LocalStorageProvider provider.
//
//   See https://angular.io/guide/dependency-injection for more info on providers
//   and Angular DI.
// */
// export class LocalStorageProvider {
//   private storage = window.localStorage;
//   constructor() {
//     console.log('Hello LocalStorageProvider Provider');
//   }
//   get(key, defaultValue){
//     let value = this.storage.getItem(key);
//     try{
//       value = JSON.parse(value);
//     }
//     catch(error){
//       value = null;
//     }
//     if(value===null && defaultValue){
//       value = defaultValue;
//     }
//     return value;
//   }
//   set(key,value){
//     this.storage.setItem(key,JSON.stringify(value));
//   }
//   remove(key){
//     this.storage.removeItem(key);
//   }
// }
