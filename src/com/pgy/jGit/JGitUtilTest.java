package com.pgy.jGit;

public class JGitUtilTest {
    public static final String repositoryPath = "/tmp/jGitTest";

    public static void main(String[] args) {
        //        init();
        //        addAll();
        //        commit();
        tag();
    }

    public static void init() {
        JGitUtil.init(repositoryPath, false);
    }

    public static void addAll() {
        JGitUtil.addAll(repositoryPath);
    }

    public static void commit() {
        JGitUtil.commit(repositoryPath, "", "", "first commit");
    }

    public static void tag() {
        JGitUtil.setTag(repositoryPath, "1.0.0", "this is the first tag");
    }
}
