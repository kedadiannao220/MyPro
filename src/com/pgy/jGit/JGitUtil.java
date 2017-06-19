package com.pgy.jGit;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JGitUtil {

    /**
     * 提交所有编辑的信息
     * @param repositoryPath
     */
    public static void addAll(String repositoryPath) {
        add(repositoryPath, new String[] { "." });
    }

    /**
     * 添加所需要提交的内容
     * @param repositoryPath
     */
    public static void add(String repositoryPath, String[] filepattern) {
        try {
            AddCommand addCmd = getGit(repositoryPath).add();
            for (String s : filepattern) {
                addCmd.addFilepattern(s);
            }
            addCmd.call();
        } catch (GitAPIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void setTag(String repositoryPath, String name, String message) {
        Git git = getGit(repositoryPath);
        try {
            git.tag().setName(name).setMessage(message).call();
        } catch (GitAPIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void delTag(String repositoryPath, String tagName) {
        Git git = getGit(repositoryPath);
        try {
            List<String> strList = git.tagDelete().setTags(tagName).call();
            System.out.println(strList);
        } catch (GitAPIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void getTagList(String repositoryPath) {
        Git git = getGit(repositoryPath);
        try {
            List<Ref> refList = git.tagList().call();
            for (Ref ref : refList) {
                System.out.println(ref.getName());
                System.out.println(ref.getLeaf());
            }
            System.out.println(refList);
        } catch (GitAPIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * git clone
     * @param url
     * @param repositoryPath
     */
    public static void clone(String url, String repositoryPath) {
        File gitDir = getRepositoryDir(repositoryPath);
        try {
            Git.cloneRepository().setURI(url).setDirectory(gitDir).call();
        } catch (GitAPIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void pull(String repositoryPath) {
        Git git = getGit(repositoryPath);
        try {
            PullResult pullResult = git.pull().call();
            System.out.println(pullResult.isSuccessful());
            System.out.println(pullResult.getMergeResult());
            System.out.println(pullResult.getRebaseResult());
        } catch (GitAPIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static Map<String, Object> status() {
        Git git = getGit("/tmp/jGitTest");
        try {
            Status status = git.status().call();
            System.out.println(status.getAdded().toString());
            System.out.println(status.getMissing().toString());
            System.out.println(status.getRemoved().toString());
            System.out.println(status.getUntracked().toString());
            System.out.println(status.getChanged().toString());
            System.out.println(status.getModified().toString());

        } catch (NoWorkTreeException | GitAPIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public static void push(String repositoryPath) {
        try {
            getGit(repositoryPath).push().call();
        } catch (GitAPIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void commit(String repositoryPath, String name, String email, String message) {
        try {
            getGit(repositoryPath).commit().setMessage(message).setCommitter(name, email).call();
        } catch (GitAPIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 初始化git Repository
     * @param dirPath 仓库目录
     * @param Bare 是否为空
     */
    public static void init(String dirPath, boolean Bare) {
        File gitDir = getRepositoryDir(dirPath);
        try {
            Git.init().setBare(Bare).setDirectory(gitDir).call();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }

    public static Git getGit(final String repositoryPath) {
        checkFile(repositoryPath);
        try {
            return Git.open(new File(repositoryPath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static Repository getRepository(String repositoryPath) {
        return getGit(repositoryPath).getRepository();
    }

    public static File getRepositoryDir(String repositoryPath) {
        checkFile(repositoryPath);
        File gitDir = new File(repositoryPath);
        try {
            FileUtils.mkdirs(gitDir);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return gitDir;
    }

    public static void checkFile(String repositoryPath) {
        File file = new File(repositoryPath);
        //TODO  此处需要添加异常提示信息
        if (!file.exists()) {
        }

        if (!file.isDirectory()) {
        }
    }
}
