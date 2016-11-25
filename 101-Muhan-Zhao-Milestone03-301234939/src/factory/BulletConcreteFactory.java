package factory;

import movingobjects.Bullet;
import movingobjects.BulletCasing;
import movingobjects.MovingObjects;

import static main.GunRangePanel.*;

public class BulletConcreteFactory extends BulletFactory
{

	@Override
	public MovingObjects createBullet(String mod, int offset, int type) {
		// TODO Auto-generated method stub
		MovingObjects bullet = null;
		
		if (mod == "bullet")
		{
			if (type == 1)
			{
				bullet = new Bullet(WIN_W/2+(offset*50*.4), WIN_H*0.8, 1);
			}
			if (type == 2)
			{
				bullet = new Bullet(WIN_W/2+(offset*50*.4), WIN_H*0.8, 2);
			}
		}
		else if (mod == "casing")
		{
			bullet = new BulletCasing(994-80, 433-5);
		}
		
		return bullet;
	}

}
