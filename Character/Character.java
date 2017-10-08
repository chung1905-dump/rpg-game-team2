package Character;
interface Character{
  int hp;
  int mp;
  // int dmg;
  int def;
  int speed;
  String img_path;
  int id;
  void attack(){}
  void useSkillQ(){}
  void useSkillW(){}
  void move(){}
}

// class Warrior extends Character{
//     void taunt(){}
//     void swingSword(){}
// }

// class Archer extends Character{
//   void run(){}
//   void rapidFire(){}
// }

// class Mage extends Character{
//   void fireBall(){}
//   void heal(){}
// }

// class Monster extends Character{
//   void superAttack(){}
// }
