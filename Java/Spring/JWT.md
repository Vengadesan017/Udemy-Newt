JWT - JSON Web Token
1. Encryption and Decrption
   - Cryptography
     - Symmetric key in both side use the same key 
       - in grp it create sepearete key for each pair 
     - Asymmetric key in both side use the same key 
       - in grp it create sepearete key for each pair
       - Algorithm
         - AES Advance
         - DES Data
         - RSA
         - ECC
     - Public vs private key
       - private key in encryption and Public key in Decryption
       - public key in encryption and private key in Decryption
       - can not use same key in both side
     - Concept
       - let a , b both had 1 private and public key
       - let a send data to b and a encrypt the data with b's pubic key
       - then in b it use its private key to decrypt data
     - Digital Signature
       - to avoid the third person malparetiecing the data
       - here the a encrpt the data with its private key
       - then in b it decrypt the data with a's public key
       - so no thierd man na edit the data
2. JWT
   - 1 the user login to the server
   - 2 server verify and send back Success msg with JWT token
   - 3 when user need data send request with token
   - 4 server verify the token  then send back the data 
   - go jwi.io
   - we the encoded and decoded data(header + Payload + Verify Signature)
3. Generate token
   - after the verify the username and password sendong the token instead of sending the success msg
   - steps
     - add dependency of jjwt-api and jjwt-impl and jjwt-jackon and devtools
     - create jwtservice class and call from controller
     - in jwtService class
     - call generate token method with getkey with secret key
     - just create and hardcode the secret key or generate the secert key
     ```
        -- COntroller
      	@Autowired
      	private UserService service;
      
      	@Autowired
      	private JwtService jwtService;
      
      	@Autowired
      	AuthenticationManager authenticationManager;
      	
      	@PostMapping("register")
      	public User register(@RequestBody User user) {
      	  return service.saveUser(user);
      	}
      
      	@PostMapping("login")
      	public String login(@RequestBody User user){
      
      		Authentication authentication = authenticationManager
      				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
      
      		if(authentication.isAuthenticated())
      			return jwtService.generateToken(user.getUsername());
      		else
      			return "Login Failed";
      
      	}


        -- Service
          private static final String SECRET = "TmV3U2VjcmV0S2V5Rm9ySldUU2lnbmluZ1B1cnBvc2VzMTIzNDU2Nzg=\r\n";
      
          private String secretKey;
      
          public JwtService(){
              secretKey = generateSecretKey();
          }
      
          public String generateSecretKey() {
              try {
                  KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
                  SecretKey secretKey = keyGen.generateKey();
                  System.out.println("Secret Key : " + secretKey.toString());
                  return Base64.getEncoder().encodeToString(secretKey.getEncoded());
              } catch (NoSuchAlgorithmException e) {
                  throw new RuntimeException("Error generating secret key", e);
              }
          }
      
          public String generateToken(String username) {
      
              Map<String, Object> claims = new HashMap<>();
      
              return Jwts.builder()
                      .setClaims(claims)
                      .setSubject(username)
                      .setIssuedAt(new Date(System.currentTimeMillis()))
                      .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
                      .signWith(getKey(), SignatureAlgorithm.HS256).compact();
      
          }
      
          private Key getKey() {
              byte[] keyBytes = Decoders.BASE64.decode(secretKey);
              return Keys.hmacShaKeyFor(keyBytes);
          }
      
          public String extractUserName(String token) {
              // extract the username from jwt token
              return extractClaim(token, Claims::getSubject);
          }
      
          private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
              final Claims claims = extractAllClaims(token);
              return claimResolver.apply(claims);
          }
      
          private Claims extractAllClaims(String token) {
              return Jwts.parserBuilder()
                      .setSigningKey(getKey())
                      .build().parseClaimsJws(token).getBody();
          }
      
      
          public boolean validateToken(String token, UserDetails userDetails) {
              final String userName = extractUserName(token);
              return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
          }
      
          private boolean isTokenExpired(String token) {
              return extractExpiration(token).before(new Date());
          }
      
          private Date extractExpiration(String token) {
              return extractClaim(token, Claims::getExpiration);
          }
     ```
4. Pass token with request
   - in postman paste the token in authorization in the type of bearer
   - create access to accept the jwt token in server
     - add one filter or multiple filter between servlet container and servlet
     - in this filter it auth the user and add filter to accept the JWS token
     - create JwtFlter class in config
     ```
      @Component
      public class JwtFilter extends OncePerRequestFilter {
      
          @Autowired
          JwtService jwtService;
      
          @Autowired
          ApplicationContext context;
      
          @Override
          protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      
              String authHeader = request.getHeader("Authorization");
              String token = null;
              String userName = null;
      
              if(authHeader != null && authHeader.startsWith("Bearer ")){
                  token = authHeader.substring(7);
                  userName = jwtService.extractUserName(token);
              }
      
              if(userName != null && SecurityContextHolder.getContext().getAuthentication()==null){
      
                  UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(userName);
      
                  if(jwtService.validateToken(token, userDetails)){
                      UsernamePasswordAuthenticationToken authToken =
                              new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                      authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                      SecurityContextHolder.getContext().setAuthentication(authToken);
                  }
              }
              filterChain.doFilter(request, response);
          }
     ```
5. Implement Oauth
   - add dependency like Oauth2 client from start.spring.io
   - add icon of google and github
   - config the oauth2 in config package as securityConfig.java
   - go to google cloud create your credentials in api ans service tab
     - save cliend id and client secret then addin application.properties
