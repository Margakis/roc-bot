var file = require('./ships.json');

class Ship {
  constructor(name, weapon, aura, zen) {
    this.name = String(name);
    this.weapon = String(weapon);
    this.aura = String(aura);
    this.zen = String(zen);
  };

  tostring(){
    return ("**" + this.name+":** Weapon: *" + this.weapon +"*, Aura: *" + this.aura + "*, Zen: *" + this.zen + "*");
  }
}

function getallships() {
  var list = "List of all ship:\n";
  for (var ship in allshipsf.ships) {
    if(String(ship.name) != ''){
      list += "\n" + ("**" + String(ship.name)+":** Weapon: *" + String(ship.weapon) +"*, Aura: *" + String(ship.aura) + "*, Zen: *" + String(ship.zen) + "*");
    }
  }
}

class AllShips{
  this.ships = {};
  static SHIPS() {return ships};
  constructor(){
    for (var ship in allshipsf.ships) {
      if(String(ship.name) != ''){
        this.ships.push(new Ship(ship.name, ship.weapon, ship.aura, ship.zen));
      }      
    }
  };   
 }

module.exports = {
  Ship: Ship,
  getallships: getallships
}

