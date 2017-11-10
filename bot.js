var Discord = require('discord.io');
var logger = require('winston');
var Ship = require('./Ship');

logger.remove(logger.transports.Console);
logger.add(logger.transports.Console, {
    colorize: true
});

logger.level = 'debug';

var bot = new Discord.Client({
   token: process.env.TOKEN,
   autorun: true
});

function listships(){
  return listships();
}

bot.on('ready', function (evt) {
    logger.info('Connected');
    logger.info('Logged in as: ' + bot.username + ' - (' + bot.id + ')');
});

bot.on('message', function (user, userID, channelID, message, evt) {
    if (message.substring(0, 1) == '!') {
        var args = message.substring(1).split(' ');
        var cmd = args[0];

        args = args.splice(1);
        switch(cmd) {
            case 'ships':
                bot.sendMessage({
                    to: channelID,
                    message: listships()
                });
            break;
         }
     }
});
