---
name: git-pr-workflow
description: Create a feature branch, commit changes, push the branch, and open a GitHub pull request with a reviewable summary.
---

# Goal
Turn completed code changes into a proper GitHub pull request workflow.

# Instructions
When this skill is used:

1. Never commit directly to `main`.
2. Check the current branch and repository status first.
3. Create a dedicated feature branch if not already on one.
4. Review changed files before committing.
5. Group changes into one or more clear commits.
6. Push the branch to origin.
7. Create a GitHub pull request.
8. Use a PR title and PR body that document:
    - the purpose of the change
    - affected services
    - affected Kafka topics and event flows
    - test steps
    - issue reference if available

# Constraints
- Do not merge the PR automatically.
- Do not force-push unless explicitly requested.
- Keep commit messages concise and conventional.

# Output format
## Branch
## Commits
## Pull request title
## Pull request summary
## Link or status