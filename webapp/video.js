<script type="text/javascript">
  var tag = document.createElement('script');
  tag.id = "iframe-demo";
  tag.src = "https://www.youtube.com/iframe_api";
  var firstScriptTag = document.getElementsByTagName('script')[0];
  firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
  var player;
  function onYouTubeIframeAPIReady() {
    player = new YT.Player('iframe_1', {
        playerVars: { 'autoplay': 0, 'controls': 1, 'playlist':'PLf8fgiSf96Yvv0LI9JCngD2UMHskRKeFS'},
        videoId: 'ti0kEycRMd8',
        events: {
          'onReady': onPlayerReady,
          'onStateChange': onPlayerStateChange
        }
    });
    player2 = new YT.Player('iframe_2', {
        playerVars: { 'autoplay': 0, 'controls': 1, 'playlist':'PLcbYgHoKSyAoe763yX5ENIGy6dpuwXE-F'},
        videoId: 'ti0kEycRMd8',
        events: {
          'onReady': onPlayerReady,
          'onStateChange': onPlayerStateChange
        }
    });

  }
  function onPlayerReady(event) {
    document.getElementById('iframe_1').style.borderColor = '#FF6D00';
    
    document.getElementById('iframe_2').style.borderColor = '#FF6D00';
  }
</script>
