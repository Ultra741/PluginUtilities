package ultradev.pluginutilities.api.util;

import java.util.List;

public interface IManager<T> {

    default void initialize() { }

    void register(T value);

    List<T> getAll();

}
