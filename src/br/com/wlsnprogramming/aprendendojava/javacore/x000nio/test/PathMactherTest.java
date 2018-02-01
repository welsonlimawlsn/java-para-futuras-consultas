package br.com.wlsnprogramming.aprendendojava.javacore.x000nio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllTest extends SimpleFileVisitor<Path> {
    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test*}.{java,class}");
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(matcher.matches(file)) {
            System.out.println(file.getFileName());
        }

        return FileVisitResult.CONTINUE;
    }
}

public class PathMactherTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta/subpasta/subsubpasta/file.bkp");
        Path path2 = Paths.get("file.bkp");
        Path path3 = Paths.get("welson-lima");

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.bkp");

        System.out.println(matcher.matches(path));
        System.out.println(matcher.matches(path2));

        Files.walkFileTree(path, new AcharTodosOsBkp());

        System.out.println("=================================================================");

        matches(path, "glob:*.bkp");
        matches(path, "glob:**.bkp");
        matches(path, "glob:**/*.bkp");
        matches(path, "glob:*");
        matches(path, "glob:**");

        System.out.println("=================================================================");

        matches(path, "glob:*.???");
        matches(path, "glob:**/*.???");
        matches(path, "glob:**.???");

        System.out.println("=================================================================");

        matches(path3, "glob:{welson*,lima*}");
        matches(path3, "glob:{welson,lima}*");
        matches(path3, "glob:{welson,lima}");

        System.out.println("=================================================================");

        Files.walkFileTree(Paths.get("./"), new FindAllTest());

    }

    private static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}
