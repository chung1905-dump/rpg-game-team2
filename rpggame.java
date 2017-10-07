class Character{
  int hp;
  int mp;
  int dmg;
  int def;
  int speed;

  void attack(){}
  void move(){}
}

class Player extends Character{
  void run(){}
  void take(){}
  void skill(){}
}

class Monster extends Character{
  void superAttack(){}
}
