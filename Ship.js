var file = require('./ships.json');

class Ship{
  constructor(name, weapon, aura, zen) {
    this.name = String(name);
    this.weapon = String(weapon);
    this.aura = String(aura);
    this.zen = String(zen);
  }
  toString(){
    return ("**" + this.name+":** Weapon: *" + this.weapon +"*, Aura: *" + this.aura + "*, Zen: *" + this.zen + "*");
  }
}

function allships() {
  var list = "";
  for (var ship in file.ships) {
    list += "\n" + ("**" + this.name+":** Weapon: *" + this.weapon +"*, Aura: *" + this.aura + "*, Zen: *" + this.zen + "*");
  }
  return list;
}

module.exports = Ship;
module.exports = allships;
