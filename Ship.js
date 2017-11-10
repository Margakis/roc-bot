var file = require('./ships.json');
module.exports = {
  Ship: class{
    constructor(name, weapon, aura, zen) {
      this.name = String(name);
      this.weapon = String(weapon);
      this.aura = String(aura);
      this.zen = String(zen);
    }

    toString: function(){
      return ("**" + this.name+":** Weapon: *" + this.weapon +"*, Aura: *" + this.aura + "*, Zen: *" + this.zen + "*");
    }
  },
  
  allships: function () {
    var list = "List of all ship:\n";
    for (var ship in allshipsf.ships) {
      if(String(ship.name) != ''){
        list += "\n" + ("**" + String(ship.name)+":** Weapon: *" + String(ship.weapon) +"*, Aura: *" + String(ship.aura) + "*, Zen: *" + String(ship.zen) + "*");
      }
    }
  }
}
