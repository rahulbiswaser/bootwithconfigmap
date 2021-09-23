# bootwithconfigmap

RoleBinding to access Configmap
oc create rolebinding default-view --clusterrole=view \
  --serviceaccount=<namespace-name>:default --namespace=<namespace-name>

/greet : Load configuration from configmap
/ : Load configuration from configmap.
/discover : Service Discovery example. Will call another conatiner with name springapptarget
/sample : Sample application for Hello World in Kubernetes & Openshift.

Useful Commands in openshift:

oc new-project test1  [namespace creation]
oc create rolebinding default-view --clusterrole=view --serviceaccount=test1:default --namespace=test1  [Assign default role to namespace test1]
oc new-app --as-deployment-config --name springapptarget --docker-image dockerforrahul/playwithdocker:v1.1  [Deploy target App in 8081 port]

oc expose service springapptarget
oc get routes

vi application.properties
oc create configmap springapp --from-file=application.properties  [create a configmap from an application.properties]

oc new-app --as-deployment-config --name springapp --docker-image dockerforrahul/bootwithconfigmap:v3.4 [Deploy Source App in 8080 port, Enabled with Discovery client & Configmap]
oc expose service springapp
oc get routes

oc set env dc/springapp --from configmap/springapp [Map configmap to existing deployment]

Test : (Domain names are dynamically created by katacode)
curl http://springapp-test1.2886795277-80-host02nc.environments.katacoda.com
curl http://springapp-test1.2886795277-80-host02nc.environments.katacoda.com/greet
curl http://springapp-test1.2886795277-80-host02nc.environments.katacoda.com/discover
