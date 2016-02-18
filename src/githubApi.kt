package github.api

@native
interface CommitInfo {
    val html_url: String
    val sha: String
    val commit: GitCommitInfo
    val author: GithubUser?
}

@native
interface GitCommitInfo {
    val author: GitUser
    val committer: GitUser
    val message: String
}

@native
interface GithubUser {
    val login: String
    val avatar_url: String
}

@native
interface GitUser {
    val name: String
    val email: String
    val date: String
}
