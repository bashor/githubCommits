package github.api

native
trait CommitInfo {
    val html_url: String
    val sha: String
    val commit: GitCommitInfo
    val author: GithubUser?
}

native
trait GitCommitInfo {
    val author: GitUser
    val committer: GitUser
    val message: String
}

native
trait GithubUser {
    val login: String
    val avatar_url: String
}

native
trait GitUser {
    val name: String
    val email: String
    val date: String
}
