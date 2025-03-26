# MS-Azure-AZ-900

- Basic level MS certification

# Cloud service
- Iaas ( Computer, Storage, Networking) - VM - pay/sec - Multiple hardware -v network as free
- Paas ( Middleware , dev tool, sql server.. load balancer..) - Azure app service - run code
- Saas (MS office , drive )
#### others
- On premise
- Serverless (low power hardware) - no option to change hardware
  - Container apps
  - kubernetes
  - SQL DB
    

# cloud type
- public
- private
- hybrid

# pricing
- https://azure.microsoft.com/en-in/pricing/calculator/

# Capital Expenses vs Operational expenses

# Benefit
 - High availability (low down time,)
   - planed outages (Update, migration, replacement)
   - unplaned outages( hardware failure,power,cyber attack, software bug)
 - Scalability
   -  Adding or Removing resources as need (Traffic)
   -  Vertical Scaling ( add cpu memory)
   -  Horizondal scaling ( add seperate server)
 - Elasticity
   - How quickly and easily do scaling
 - Reliability
   - Ability of system recover from failures
     - hardware Failure , Network Interruptions , power failures , Large-scale region
 - Predictability
    - Ability to forecast and control the performanvce and behavior of system and cost
 - Security
    - use industry standard (ISO)
    - Microsoft security response center
    - Role based access
    - Up to date
    - Encryption by default
 - Governance
    - Auditing and reporting
    - Azure policy and blueprint
    - Guides and best practice
  - Managability
    - Templates
    - Scaling
    - Web portal
    - PowerShell
      
# Core Architecture components
  - Region (based on usage and high speed connection) 60+ region
  - Sovereign azure (not connect to public cloud , need subscription ,diff standard)
  - Zone ( seperate center in each region with high speed network)
  - Resource (Resources < Resources grp < subscription < Management grp)
     - resource - are hardware , software
     - resource group - Logical group of resources (create delete all resource at time )
     - Subsription - billing unit
     - Management group - multiple subsription for single administration

# compute service
 - Types
    - Virtual machines - laas 
    - VM scale set - top of vm - scale up / scale down with load balancer
    - App services -app in cloud - paas
    - Azure Container Instance  - single instance , quickest way to deploy a container
    - Azure kubernetes service
    - Azure virtual desktop - v desktop run in cloud
    - Azure Function - small pieces od code run in cloud - 1million execution / month as free for 1st month by serverless model
  - Availability set
    - fault isolation - separete power , network switch for update one at a time
# network service
  - Virtual network as laas
  - it be a IPV4 or IPV 6 but is can't access outside of azure because is private
  - all VN is divided as more subnets
  - the one vm had atleast one subnet
  - peering
    - connect to subnet together
    - communication between vm using subnet on different network is blocked so use peering
  - DNS
    - can use domain name for ip but it internally use only
  - VPN
    - inside azure can install vpn gateway
  - Express Route
     - private connection from isp to Azure endpoint for high speed comminication
  - Networking Option in Azure
     - Public access from all network
     - Public access from selectged VN and IP address
     - use private access

# Storage (laas) GPv2
 - Redundancy - make 3 copy of each data
 - Global redundance - 3 local and 3 in another region
 - Access tier
    - Hot - default balanca access
    - cool -cheaper storage , expensive read , write
    - Cold - Much cheaper , more expensive read ,write
    - Archive - connot get immediate access cheapest
 - standared storage 
    - contain , file , queue , table
    - upto 5 PB
    - pay for use
    - cheap
 - Data lake
   - Extremely large storage
   - upto PB EB
   - for big data
 - Binary Large Object BLOB
   - txt pdf zip csv jpg files
   - Unstructure
   - stored loosely in container
   - publick or private
 - Container storage
   - multiple container contain multiple blob
  

# Demo
- VM
   - create VM with OS
   - download RDP(Remote Desktop Protocol file) file connection tap to open the VM
- App service
  - create App service with runtime stack py3.8 or .net 8 and also os
  -  copy the default url . paste in browser (no manul installtion needed automatic from git rep)
  -  can change the resource size( scaling 1.manual 2.auto rule based)
- Function App
   - create function instance with code or container
   - with tech stack( programming language) with vertion version
   - with OS
   - can also scale with premium plan
   - set template like HTTP trigger, timer to code
   - copy the dynamic link and paste in brower which is access by any one 

- Container instance
   - create with os image
   - for testing  in low power h/w
- Container App
   - create with container app environment (image file)
   - can scale
   - Public dynamic domain url is also available
- delete instance
   - go to resource group
   - delete resource group option
- Storage Account
   - create with performance , account type(block , file , page) , redundance(local,global)
   - then create container as public or private
   - then upload the blob
   - to access private fils generaTE SAS token that give new url
   - also set rules like move automatically hot to cold
   - use storage explorer to access the contain
   -  Azure file sync used to synchronize data between on premises server and Azure file share
   - use Azcopy to copy bluk data from one container to another
     azcopy copy source_SAS_KEY Destination_SAS_KEY
   - Data box 100TB or DataBOx Heavy 1PB or DataBoxDisk 8TB
      - used to upload BIG size data 
      - ms send to data box to your place you copy your data and ship the data box to ms azure they copy data to your colud

# Identity Management
- person , Application , Device
- Login with password , key , certificate
- use Entra ID( use protocal SAML & Oauth ) used Active directory to handle authentication(use userId & password to access) and authorization( ensuring user is permitted)
- benifit of entra ID 
  - security
  - easier support
  - single sign-on
- use multi factor Authentication (ms auth app , mail,FIDO2 security key , hardware token, s/w token, sms)
- Passwordless - high security & convenient - the aboue methods ( and also figure print,face ,pin,bluetooth)
- Role Based control
  - create role
  - IT Security
  - assign user to those role
  - Roles 1.Reader 2.COntributor 3.Owner
- Zero trust model  (everthing inside the corporate network is safe but outside is not safe) use security policy enforcement
- MS defender for cloud ( enhance security on your subscription) tool can continually assess your cross-cloud resources for security issues and allows you to review your secure score?

# Cost management
- flexible pricing (/sec , /hr , /month , /GB, /CPU)
- Factors (time, usage, service tier, power, s/w licence)
- caveat (free plan)
- use price calculator
- Total cost Ownership ( used to estimate the cost saving instead of on premises) and compare both 
- Resource tag - create multiple tag for instance then use that tag for view instance report based on tags

# Governance and Compliance
- company had set of rules for security , legal governance
- type of rule
  - all server must be running s/w within ms guideline
  - minimum 24hr od backub
  - firewalls block all inbound posrt excep 443
  - only operation suppoer can reboot production servver
- azure policy (ex: must sql server 12.0 . automatically apply tagging...)
  - go to palicy page search policy then select policy then assign the policy with scope
- Locks
  - read only lock - only access to read
  - not delete lock - not able to delete
- Microsoft purview - Data security, governance, and compliance together.

# Azure portol
- GUI based interface come with dashboard and we will create and manage instance and also see and paying the bill
- Also had termical for Command line interface
  - by defaul linux terminal we can view by az vm list
  - also download azure  cli in our local system

# Azure arc
- cross platform vm and container management
- Work with Azure policy , Kubernetes clusters

# Infrastructure as code
- do backup all the config , storage , db setting ,load banlancer setting in github

# ARM Template - Azure resource manager - management layer
- all action like create , update , delete from CLI, PowerShell,portal reast client to instance (azure resource) goes throug the arm layer
- during the creation of instance we can see the arm template and create the templete that template save all the info to create instance, it can help rto quick creation of instance repeatedly
  
# Monitoring
- Advisor - give recommandation for cost , security, reliablity, performance, operation excellecnce
- Health service - give alert when the any region had issue
- Monitoring insight - is apm dor developer and devops which detect the perfomance automatically and include poserful analytics tools to diagnose the issue. which an option during the instance creating process
- Monitoring logs - view the Logs with the scope(VM, storage account ) and store in table then show in chart
  

  
