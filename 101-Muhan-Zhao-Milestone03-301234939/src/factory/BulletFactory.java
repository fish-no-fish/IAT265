package factory;

import movingobjects.Bullet;
import movingobjects.MovingObjects;

public abstract class BulletFactory 
{
	abstract MovingObjects createBullet(String mod, int offset, int type);
}
