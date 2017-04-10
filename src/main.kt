package github.commits

import d3.d3
import github.api.CommitInfo
import jquery.getJSON
import jquery.hide
import jquery.jq
import jquery.show
import kotlinjs.array.ext.push
import kotlinjs.array.ext.sort

val GET_KOTLIN_COMMITS = "https://api.github.com/repos/JetBrains/kotlin/commits?sha=master&per_page=100"
val GET_KOTLIN_COMMITS_LOCAL = "/githubCommits/commits.json"

val DEFAULT_AVATAR = "https://assets.github.com/images/gravatars/gravatar-user-420.png"

class CommitStat(val authorName: String, val commitCount: Int)

fun main(args: Array<String>) {
    // TODO replace with fetch
    jq {
        jq.getJSON<Array<CommitInfo>>(GET_KOTLIN_COMMITS) { commits, status, jqXHR ->
            val commitsDiv = jq("#commits")

            val name2id = HashMap<String, Int>()

            var id = 0

            for (commit in commits) {
                val name = commit.commit.author.name

                if (!name2id.containsKey(name)) {
                    name2id[name] = id++
                }

                commitsDiv.append("""
                    <div class='author_${name2id[name]}'>
                        <a href=${commit.html_url}>${commit.sha.substring(0, 6)}</a>
                        <span>${commit.commit.message}</span>
                    </div>""")
            }

            updateChart(commits, name2id)
        }
    }
}

fun updateChart(commits: Array<CommitInfo>, name2id: Map<String, Int>) {
    // Group by commit author name
    val map = HashMap<String, Int>()
    var max = 0
    val name2avatar = HashMap<String, String>()

    for (commit in commits) {
        val commitAuthorName = commit.commit.author.name

        val oldValue = map[commitAuthorName] ?: 0
        map[commitAuthorName] = oldValue + 1

        val author = commit.author

        if (author != null) {
            name2avatar[commitAuthorName] = author.avatar_url
        }

        if (max <= oldValue) {
            max = oldValue + 1
        }
    }

    // Copy data to array
    val data = arrayOf<CommitStat>()
    for (k in map.keys) {
        data.push(CommitStat(k, map[k]!!))
    }

    data.sort { a, b -> b.commitCount - a.commitCount }

    // Setup scale
    val x = d3.scale.linear()
            .domain(arrayOf(0, max))
            .range(arrayOf(0, 420))

    // Setup bar drawing
    val line =
            d3.select("#chart")
                    .selectAll("div")
                    .data(data)
                    .enter().append("div")

    val bar = line.append("div")
    bar.classed("bar-container", true)

    bar.append("img")
            .attr("src") { d -> name2avatar[d.authorName] ?: DEFAULT_AVATAR }
            .attr<Unit>("title") { d -> d.authorName }

    bar.append("div")
            .classed("bar", true)
            .style("width", { d -> "${x(d.commitCount)}px" })
            .text { d -> "${d.commitCount}" }

    // Setup event handlers
    bar.on("mouseenter") { d ->
        jq("#commits div").hide()
        jq(".author_${name2id[d.authorName]}").show()
    }

    bar.on("mouseleave") { data ->
        jq("#commits div").show()
    }
}

