const mongoose = require('mongoose');

const { Schema } = mongoose;
//const { Types: { ObjectId } } = Schema;
const chatSchema = new Schema({
  toUser: {
    type: String,
    required: true,
  },
  fromUser: {
    type: String,
    required: true,
  },
  msg: String,
  createdAt: {
    type: Date,
    default: Date.now,
  },
});

module.exports = mongoose.model('Chat', chatSchema);
