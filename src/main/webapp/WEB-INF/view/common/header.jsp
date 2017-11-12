<nav class="navbar navbar-expand-lg sticky-top navbar-light bg-white">
  <a class="navbar-brand" href="/">
    <img src="/assets/logo.jpg" width="100" height="60" class="d-inline-block align-top" alt="">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link ${location==0? 'active': ' '}" href="/">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link ${location==1? 'active': ' '}" href="/register">Register</a>
      <a class="nav-item nav-link ${location==2? 'active': ' '}" href="/users">User List</a>
    </div>
  </div>
</nav>