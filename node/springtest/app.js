const app = require('express')();
//const cors = require('cors');
const connect = require('./schemas');
const dotenv = require('dotenv');
//const MongoClient = require('mongoose')
dotenv.config();
const loginID = {};
const Chat = require('./schemas/chat');
//app.use(cors());
const http = require('http').Server(app);
const io = require("socket.io")(http, {
    cors: {
      origin: "*",
      methods: ["GET", "POST"],
      allowedHeaders: ["Access-Control-Allow-Origin"],
      credentials: false
    },
    transport: ['websocket']
  });
connect();

//const chat = io.of('/chat');

io.on('connection', function (socket) {
    const date = new Date;
    
    console.log(`한명의 유저가 접속을 했습니다.${date}`);




     socket.on("login",function(userNo){
         console.log("서버가 login 이벤트를 받았습니다"); 
	// 	console.log("접속한 소켓 id: " + socket.id); 
	// 	// QR_qVIARIFJIEJF -> 이런 복잡한 숫자값이 나옴
				
	// 	//매핑정보를 담는 loginID에 login.id를 Key 값으로 하여, socket.id를 저장
	 	loginID[userNo] = socket.id; 
		
        console.log("loginID[userNo] " + loginID[userNo]);
	// 	// 클라이언트에서 받은 데이터를 socket 객체에 속성으로 추가 -> 내가 고유값을 직접 설정하는 과정
	 	socket.loginID = userNo;
		
	// 	console.log("접속한 클라이언트 id 갯수: " + 
	// 			Object.keys(loginID).length); 
	// 	// 이 login.id들은 loginID의 property의 key들로 저장이 되었기 때문에,
	// 	// Object.keys(loginID)를 이용하여 key들의 갯수를 추출할 수 있다		
		
		
	});



    


    socket.on('disconnect', function () {
        delete loginID[socket.loginID];
        console.log(`한명의 유저가 접속해제를 했습니다.${date}`);
    });
 
    // socket.on('send_msg', function (msg) {
    //     console.log(msg);
    // });

    // socket.on('write_msg',function (toId, msg){
        
    // });

    socket.on('write_msg', function (toId, msg) {
        
        const chat = Chat.create({
            toUser: toId,
            fromUser: socket.loginID,
            msg: msg,
          });


        io.to(loginID[toId]).emit("send_msg" ,msg,socket.loginID); 
        //io.to(loginID[toId]).emit("send_msg" ,"chat"); 
        //io.of('/chat').to(loginID[toId]).emit("send_msg", msg,socket.loginID);
        console.log("msg" + msg);
        console.log("보낸이" + socket.loginID);
        console.log("받는이" + toId);

        console.table(loginID);
        //다시, 소켓을 통해 이벤트를 전송한다.
        //io.emit('send_msg', msg);

        // MongDB에다가 DB저장해야함. 
        //1. ROOM으로 해야할까? 
        //2. 아니면 MONGODB로 어캐해야하지? 
    });

    socket.on('send_user_Id', function (msg) {
        //socket.id = msg;
        console.log("UserID:" + msg);
        console.log("socket.id : " + socket.id);
    });

    socket.on('mgsList', function (toUserNo,userNo) {
        //

        Chat.find({$or:[{toUser:toUserNo, fromUser:userNo},{toUser:userNo, fromUser:toUserNo}]}).sort({createdAt:1}).exec(function(err,chats){
            for(let i = 0; i < chats.length; i++){
                var dbData = {
                    toUser: chats[i].toUser,
                    fromUser: chats[i].fromUser,
                    msg: chats[i].msg,
                    createdAt: chats[i].createdAt,
                };
                socket.emit('receiveMgsList', dbData);
            }
        });
       // let recieveMsgchats = Chat.find({toUser:toUserNo, fromUser:userNo},function(err,chats){
            
        //});
        //let sendMsgchats= Chat.find({toUser:userNo, fromUser:toUserNo},function(err,chats){
            
        //});
        // let SerialrecieveMsgchats = {
        //     _id: recieveMsgchats._id,
        //     toUser: recieveMsgchats.toUser,
        // }
      // console.log(recieveMsgchats(toUserNo,userNo));
      // console.log(recieveMsgchats(toUserNo,userNo));
        //for(let i = 0; i < recieveMsgchats.length; i++){
         //   SerialrecieveMsgchats += JSON.stringify(recieveMsgchats[i]);
       // }
        //console.log((SerialrecieveMsgchats));
       // socket.emit('receiveMgsList', recieveMsgchats(toUserNo,userNo)
         //{
         //name: recieveMsgchats(toUserNo,userNo),
        // sendMsg: "sendMsgchats",
       //  }
          
       //  );
       // console.log("UserID:" + msg);
        //console.log("socket.id : " + socket.id);
    });


});
 
http.listen(8002, function () {
    console.log('listening on *:8002');
});
