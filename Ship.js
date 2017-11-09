class Ship{
  constructor(name, weapon, aura, zen) {
    this.name = String(name);
    this.weapon = String(weapon);
    this.aura = String(aura);
    this.zen = String(zen);
  }
  toString(){
    return (name+" Weapon: " + weapon +", Aura: " + aura + ", Zen: " + zen);
  }
}

 module.exports = Ship;
