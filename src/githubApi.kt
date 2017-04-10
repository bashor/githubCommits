package github.api

external interface CommitInfo {
    val html_url: String
    val sha: String
    val commit: GitCommitInfo
    val author: GithubUser?
}

external interface GitCommitInfo {
    val author: GitUser
    val committer: GitUser
    val message: String
}

external interface GithubUser {
    val login: String
    val avatar_url: String
}

external interface GitUser {
    val name: String
    val email: String
    val date: String
}
