package ru.job4j.solid.isp;

import java.util.Iterator;
/* Ошибка ISP.
 */

public interface Terrain<T> {

    Iterator<T> plain();

    Iterator<T> steppe();

    Iterator<T> mountains();

    Iterator<T> hills();
}
