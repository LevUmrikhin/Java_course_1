package task12;
import task12.realClasses.Singer;

import java.util.List;

public interface SingerDao {
    public List<Singer> findSingers() throws InterruptedException;
    public void saveSingers(List<Singer> singers) throws InterruptedException;
}
