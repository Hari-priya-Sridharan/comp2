----Mongo DB

Login -
mongosh --username user --authenticationDatabase test

Find all documents in collection -
db.tweet.find()
db.user.find()

Delete All -
db.tweet.deleteMany({})
db.user.deleteMany({})

Delete All with condition-
db.tweet.deleteMany({field : value})
db.user.deleteMany({field : value})


----Run App
java -jar tweet-app-v1.0.jar

----App Link
http://tweet-ui-bucket.s3-website.ap-south-1.amazonaws.com
