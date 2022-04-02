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

4、Codeless ds-sdk usage reference
```
4.1. Apply for an account on the codeless platform and save the Codeless-Token certificate
4.2. Introduce ds-sdk jar into the project.
4.3. Add configuration to the project:
         ds.address.protocol
         ds.address.ip
         ds.address.port
         ds.address.uri
4.4. Call the deployment process api, inject DSEngine, call dsEngine.workflow().createDeploymentByJSONFile method, the parameter is the json file of the flowchart
```
