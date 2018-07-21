<script type="text/javascript">
  var tag = document.createElement('script');
  tag.id = "iframe-demo";
  tag.src = "https://www.youtube.com/iframe_api";
  var firstScriptTag = document.getElementsByTagName('script')[0];
  firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
  var player;
  function onYouTubeIframeAPIReady() {
    player = new YT.Player('existing-iframe-example', {
        playerVars: { 'autoplay': 0, 'controls': 1, 'playlist':'PLf8fgiSf96Yvv0LI9JCngD2UMHskRKeFS'},
        videoId: 'ti0kEycRMd8',
        events: {
          'onReady': onPlayerReady,
          'onStateChange': onPlayerStateChange
        }
    });
  }
  function onPlayerReady(event) {
    document.getElementById('existing-iframe-example').style.borderColor = '#FF6D00';
  }
</script>
