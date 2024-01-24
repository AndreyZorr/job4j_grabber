package ru.job4j.condition;

//Принципы Kiss, Dry и Yagni

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Search {

      /*  static List<File> findByMask(String mask) {
            List<File> result = new ArrayList<>();
            for (File file : ..) {
                if (Pattern.matches(mask, file.getName())) {
                    result.add(file);
                }
            }
            return result;
        }

        static List<File> findByName(String name) {
            List<File> result = new ArrayList<>();
            for (File file : ..) {
                if (name.equals(file.getName())) {
                    result.add(file);
                }
            }
            return result;
        }

        static List<File> findByExtension(String extension) {
            List<File> result = new ArrayList<>();
            for (File file : ..) {
                if (file.getName().endWiths(extension)) {
                    result.add(file);
                }
            }
            return result;
        }
    }*/

   /* static List<File> findBy(Predicate<File> predicate) {
        List<File> result = new ArrayList<>();
        for (File file : ..) {
            if (predicate.test(file)) {
                result.add(file);
            }
        }
        return result;
    }
    static List<File> findByMask(String mask) {
        return findBy(file -> Pattern.matches(mask, file.getName()));
    }

    static List<File> findByName(String name) {
        return findBy(file -> file.getName().equals(name));
    }

    static List<File> findByExt(String extension) {
        return findBy(file -> file.getName().endsWith(extension));
    }*/
}
