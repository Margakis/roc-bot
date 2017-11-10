var Discord = require('discord.io');
var logger = require('winston');
var Ship = require('./Ship');
var allshipsf = require('./ships.json');

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
  return allships();
}

bot.on('ready', function (evt) {
    logger.info('Connected');
    logger.info('Logged in as: ' + bot.username + ' - (' + bot.id + ')');
    wraith = new Ship("Wraith", "Electron laser", "Vorpal lance", "Mega bomb");
    logger.info('Ship-class test: '+wraith.tostring(); 
});

bot.on('message', function (user, userID, channelID, message, evt) {
    if (message.substring(0, 1) == '!') {
        var args = message.substring(1).split(' ');
        var cmd = args[0];

        args = args.splice(1);
        switch(cmd) {
            case 'ships':
                logger.info('Recieved cmd: ' + cmd
                        + ', With the arguments: ' + args)

                var list = "List of all ship:\n";
                for (var ship in allshipsf.ships) {
                  if(String(ship.name) != ''){
                    list += "\n" + ("**" + String(ship.name)+":** Weapon: *" + String(ship.weapon) +"*, Aura: *" + String(ship.aura) + "*, Zen: *" + String(ship.zen) + "*");
                  }
                }
                bot.sendMessage({
                    to: channelID,
                    message: (
                      "Test:\n" + list
                    )
                });
            break;
         }
     }
});
