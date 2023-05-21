# itpu-household-appliances-warehouse
ITPU Course project


## Developer Guide

Make sure you have setup your local Git Hooks:

```sh
git config core.hooksPath .githooks
```

This will make sure your commit messages follow the [Conventional Commits Specification](https://www.conventionalcommits.org/en/v1.0.0/).

## Semantic Versioning

This project uses `standard-release` to update the version in the `pom.xml` file from the changes in the history and to create the `CHANGELOG.md` file.

To setup semantic versioning and create the baseline changelog, run:

```sh
npx dwmkerr/standard-version --first-release --packageFiles pom.xml --bumpFiles pom.xml
```

Now any time you want to cut a new release, run:

```sh
npx dwmkerr/standard-version --packageFiles pom.xml --bumpFiles pom.xml
```

This will:

- Update the `CHANGELOG.md`
- Update the version number based on the commit history
- Create a git tag with the new version number

Finally, just push the tag to trigger a deployment of the new version:

```sh
git push --follow-tags
```

## Major Version Zero

As per the spec: https://semver.org/spec/v2.0.0.html#doesnt-this-discourage-rapid-development-and-fast-iteration please note that Major Version 0 (i.e. `0.x.y`) is for about rapid development. Major changes do _not_ increase the major version number - only the minor version number. This is in alignment with the semver spec, that reserves major version zero for rapid changes that are expected to break the API.