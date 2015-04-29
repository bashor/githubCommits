(function (Kotlin) {
  'use strict';
  var _ = Kotlin.defineRootPackage(null, /** @lends _ */ {
    github: Kotlin.definePackage(null, /** @lends _.github */ {
      commits: Kotlin.definePackage(function () {
        this.GET_KOTLIN_COMMITS = 'https://api.github.com/repos/JetBrains/kotlin/commits?sha=master&per_page=100';
        this.GET_KOTLIN_COMMITS_LOCAL = '/githubCommits/commits.json';
        this.DEFAULT_AVATAR = 'https://assets.github.com/images/gravatars/gravatar-user-420.png';
      }, /** @lends _.github.commits */ {
        CommitStat: Kotlin.createClass(null, function (authorName, commitCount) {
          this.authorName = authorName;
          this.commitCount = commitCount;
        }),
        updateChart$f: function (a, b) {
          return b.commitCount - a.commitCount;
        },
        updateChart$f_0: function (name2avatar) {
          return function (d) {
            var tmp$0;
            return (tmp$0 = name2avatar.get_za3rmp$(d.authorName)) != null ? tmp$0 : _.github.commits.DEFAULT_AVATAR;
          };
        },
        updateChart$f_1: function (d) {
          return d.authorName;
        },
        updateChart$f_2: function (x) {
          return function (d) {
            return x(d.commitCount) + 'px';
          };
        },
        updateChart$f_3: function (d) {
          return d.commitCount.toString();
        },
        updateChart$f_4: function (name2id) {
          return function (d) {
            $('#commits div').hide();
            return $('.author_' + Kotlin.toString(name2id.get_za3rmp$(d.authorName))).show();
          };
        },
        updateChart$f_5: function (_) {
          return $('#commits div').show();
        },
        updateChart: function (commits, name2id) {
          var map = new Kotlin.PrimitiveHashMap();
          var max = 0;
          var name2avatar = new Kotlin.PrimitiveHashMap();
          var tmp$0, tmp$1, tmp$2;
          {
            tmp$0 = commits, tmp$1 = tmp$0.length;
            for (var tmp$2 = 0; tmp$2 !== tmp$1; ++tmp$2) {
              var commit = tmp$0[tmp$2];
              var commitAithorName = commit.commit.author.name;
              var tmp$3;
              var oldValue = (tmp$3 = map.get_za3rmp$(commitAithorName)) != null ? tmp$3 : 0;
              map.put_wn2jw4$(commitAithorName, oldValue + 1);
              var author = commit.author;
              if (author != null) {
                name2avatar.put_wn2jw4$(commitAithorName, author.avatar_url);
              }
              if (max <= oldValue) {
                max = oldValue + 1;
              }
            }
          }
          var data = [];
          {
            var tmp$4 = map.keySet().iterator();
            while (tmp$4.hasNext()) {
              var k = tmp$4.next();
              var tmp$5;
              data.push(new _.github.commits.CommitStat(k, (tmp$5 = map.get_za3rmp$(k)) != null ? tmp$5 : Kotlin.throwNPE()));
            }
          }
          data.sort(_.github.commits.updateChart$f);
          var x = d3.scale.linear().domain([0, max]).range([0, 420]);
          var line = d3.select('#chart').selectAll('div').data(data).enter().append('div');
          var bar = line.append('div');
          bar.classed('bar-container', true);
          bar.append('img').attr('src', _.github.commits.updateChart$f_0(name2avatar)).attr('title', _.github.commits.updateChart$f_1);
          bar.append('div').classed('bar', true).style('width', _.github.commits.updateChart$f_2(x)).text(_.github.commits.updateChart$f_3);
          bar.on('mouseenter', _.github.commits.updateChart$f_4(name2id));
          bar.on('mouseleave', _.github.commits.updateChart$f_5);
        },
        f: function (commits, status, jqXHR) {
          var commitsDiv = $('#commits');
          var name2id = new Kotlin.PrimitiveHashMap();
          var id = 0;
          var tmp$0, tmp$1, tmp$2;
          {
            tmp$0 = commits, tmp$1 = tmp$0.length;
            for (var tmp$2 = 0; tmp$2 !== tmp$1; ++tmp$2) {
              var commit = tmp$0[tmp$2];
              var name = commit.commit.author.name;
              if (!name2id.containsKey_za3rmp$(name)) {
                name2id.put_wn2jw4$(name, id++);
              }
              commitsDiv.append('\n' + "                    <div class='author_" + Kotlin.toString(name2id.get_za3rmp$(name)) + "'>" + '\n' + '                        <a href=' + commit.html_url + '>' + commit.sha.substring(0, 6) + '<\/a>' + '\n' + '                        <span>' + commit.commit.message + '<\/span>' + '\n' + '                    <\/div>');
            }
          }
          _.github.commits.updateChart(commits, name2id);
        },
        main$f: function () {
          $.getJSON(_.github.commits.GET_KOTLIN_COMMITS, _.github.commits.f);
        },
        main: function (args) {
          $(_.github.commits.main$f);
        }
      })
    })
  });
  Kotlin.defineModule('githubCommits', _);
  _.github.commits.main([]);
}(Kotlin));
