# ds-sdk
# about developer

1. version control

2. schema
2.1 git push message schema should in format `<type>(<scope>): <subject>`
- type should be in `build`, `ci`, `docs`, `feat`, `fix`, `perf`, `style`, `test`, `restructure` .
- scope should be in module name.
- subject should be describe the subject content.

for example 
```
docs(changelog): update change log to beta.5
fix(release): need to depend on latest rxjs and zone.
```

3. statement for directory
