
'use strict';

const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();
const path = require('path');
const os = require('os');
const fs = require('fs');
const {Storage} = require('@google-cloud/storage');

exports.updateLink= functions.storage.object().onFinalize(async(object)=>{

    const basePath= "https://fir-demo-b26a3.firebaseio.com/";
    const filePath = object.name;
    const finalPath=path.join(basePath,filePath);
    
    const fileDir = path.dirname(filePath);
    const fileName = path.basename(filePath);
   const f= filePath.split(".");
   console.log("name  "+f[0]);
  
    const storage = new Storage();

    const storageBucket = admin.storage().bucket( 'gs://fir-demo-b26a3.appspot.com' );
    const file = storageBucket.file(filePath);

  

   const config = {
    action: 'read',
    expires: '03-17-2025'
  };
  
  file.getSignedUrl(config, function(err, url) {
    if (err) {
      console.error(err);
      return;
    }
  
    // The file is now available to read from this URL.
    //request(url, function(err, resp) {
      // resp.statusCode = 200
  //  });


    const fileLink=object.selfLink;
   const mediaLink= object.mediaLink;
   console.log("path= "+finalPath+ " Link = "+ fileLink + " media link "+mediaLink+ " URL "+ url);
/*
   async function makePublic() {
     // Makes the file public
     await storage.bucket(storageBucket).file(fileName).makePublic();
 
     console.log(`gs://${bucketName}/${filename} is now public.`);
   }
 
   makePublic().catch(console.error);
   */



   return admin.database().ref("/"+f[0]).set(url);
    })

});
