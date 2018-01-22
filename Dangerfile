github.dismiss_out_of_range_messages

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
warn("PR is classed as Work in Progress") if github.pr_title.include? "[WIP]"

# Warn when there is a big PR
warn("Big PR") if git.lines_of_code > 500

checkstyle_format.base_path = Dir.pwd
checkstyle_format.report 'build/reports/ktlint/main-lint.xml'
