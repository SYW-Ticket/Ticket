webpackJsonp([1],{698:function(e,t,i){"use strict";var s=i(229),n=i(699),r=i(700),a=i(725),o=i(730),l=i(732),d=i(591),c=s.createClass({displayName:"IndexView",mixins:[d],componentDidMount:function(){this.getFlux().actions.application.setNavbar({type:"menu"}),n.track("浏览首页")},render:function(){return s.createElement("section",{className:"content"},s.createElement(r,null),s.createElement(a,null),s.createElement(o,null),s.createElement(l,null))}});e.exports=c},700:function(e,t,i){"use strict";var s=i(229),n=(i(5),i(701)),r=(i(215),i(226).redirect,i(591)),a=i(592).StoreWatchMixin,o=i(723),l=s.createClass({displayName:"BillboardCarousel",mixins:[r,a("BillboardStore")],getStateFromFlux:function(){var e=this.getFlux();return{billboards:e.store("BillboardStore").getHomeBillboards().models}},componentDidMount:function(){this.getFlux().actions.billboard.home()},render:function(){var e=this,t={dots:!0,autoplay:!0,autoplaySpeed:5e3,arrows:!1},r=_.chain(e.state.billboards).sortBy(function(e){return-e.get("id")}).sortBy(function(e){return e.get("weight")}).map(function(e){return s.createElement("div",{key:e.get("id"),"data-growing-title":e.get("name")},s.createElement("a",{href:e.get("url"),target:"_blank"},s.createElement(o,{className:"img-responsive",src:e.get("imageUrl")||i(724),placeholder:i(724),alt:""})))}).value();return s.createElement(n,t,r)}});e.exports=l},701:function(e,t,i){"use strict";e.exports=i(702)},702:function(e,t,i){"use strict";function s(e){return e&&e.__esModule?e:{"default":e}}var n=i(229),r=s(n),a=i(703),o=i(708),l=s(o),d=i(714),c=s(d),u=i(716),h=s(u),p=i(710),f=s(p),m=r["default"].createClass({displayName:"Slider",mixins:[h["default"]],getInitialState:function(){return{breakpoint:null}},componentDidMount:function(){var e=this;if(this.props.responsive){var t=this.props.responsive.map(function(e){return e.breakpoint});t.sort(function(e,t){return e-t}),t.forEach(function(i,s){var n;n=0===s?(0,c["default"])({minWidth:0,maxWidth:i}):(0,c["default"])({minWidth:t[s-1],maxWidth:i}),e.media(n,function(){e.setState({breakpoint:i})})});var i=(0,c["default"])({minWidth:t.slice(-1)[0]});this.media(i,function(){e.setState({breakpoint:null})})}},render:function(){var e,t,i=this;return this.state.breakpoint?(t=this.props.responsive.filter(function(e){return e.breakpoint===i.state.breakpoint}),e="unslick"===t[0].settings?"unslick":(0,l["default"])({},this.props,t[0].settings)):e=(0,l["default"])({},f["default"],this.props),"unslick"===e?r["default"].createElement("div",null,this.props.children):r["default"].createElement(a.InnerSlider,e,this.props.children)}});e.exports=m},703:function(e,t,i){"use strict";function s(e){return e&&e.__esModule?e:{"default":e}}Object.defineProperty(t,"__esModule",{value:!0});var n=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var i=arguments[t];for(var s in i)Object.prototype.hasOwnProperty.call(i,s)&&(e[s]=i[s])}return e},r=i(229),a=s(r),o=i(704),l=s(o),d=i(707),c=s(d),u=i(709),h=s(u),p=i(710),f=s(p),m=i(386),v=s(m),g=i(711),S=i(712),w=i(713),y=a["default"].createClass({displayName:"InnerSlider",mixins:[c["default"],l["default"]],getInitialState:function(){return h["default"]},getDefaultProps:function(){return f["default"]},componentWillMount:function(){this.props.init&&this.props.init(),this.setState({mounted:!0});for(var e=[],t=0;t<a["default"].Children.count(this.props.children);t++)t>=this.state.currentSlide&&t<this.state.currentSlide+this.props.slidesToShow&&e.push(t);this.props.lazyLoad&&0===this.state.lazyLoadedList.length&&this.setState({lazyLoadedList:e})},componentDidMount:function(){this.initialize(this.props),this.adaptHeight(),window.addEventListener?window.addEventListener("resize",this.onWindowResized):window.attachEvent("onresize",this.onWindowResized)},componentWillUnmount:function(){window.addEventListener?window.removeEventListener("resize",this.onWindowResized):window.detachEvent("onresize",this.onWindowResized),this.state.autoPlayTimer&&window.clearInterval(this.state.autoPlayTimer)},componentWillReceiveProps:function(e){this.props.slickGoTo!=e.slickGoTo?this.changeSlide({message:"index",index:e.slickGoTo,currentSlide:this.state.currentSlide}):this.update(e)},componentDidUpdate:function(){this.adaptHeight()},onWindowResized:function(){this.update(this.props)},render:function(){var e,t=(0,v["default"])("slick-initialized","slick-slider",this.props.className),i={fade:this.props.fade,cssEase:this.props.cssEase,speed:this.props.speed,infinite:this.props.infinite,centerMode:this.props.centerMode,currentSlide:this.state.currentSlide,lazyLoad:this.props.lazyLoad,lazyLoadedList:this.state.lazyLoadedList,rtl:this.props.rtl,slideWidth:this.state.slideWidth,slidesToShow:this.props.slidesToShow,slideCount:this.state.slideCount,trackStyle:this.state.trackStyle,variableWidth:this.props.variableWidth};if(this.props.dots===!0&&this.state.slideCount>this.props.slidesToShow){var s={dotsClass:this.props.dotsClass,slideCount:this.state.slideCount,slidesToShow:this.props.slidesToShow,currentSlide:this.state.currentSlide,slidesToScroll:this.props.slidesToScroll,clickHandler:this.changeSlide};e=a["default"].createElement(S.Dots,s)}var r,o,l={infinite:this.props.infinite,centerMode:this.props.centerMode,currentSlide:this.state.currentSlide,slideCount:this.state.slideCount,slidesToShow:this.props.slidesToShow,prevArrow:this.props.prevArrow,nextArrow:this.props.nextArrow,clickHandler:this.changeSlide};return this.props.arrows&&(r=a["default"].createElement(w.PrevArrow,l),o=a["default"].createElement(w.NextArrow,l)),a["default"].createElement("div",{className:t,onMouseEnter:this.onInnerSliderEnter,onMouseLeave:this.onInnerSliderLeave},a["default"].createElement("div",{ref:"list",className:"slick-list",onMouseDown:this.swipeStart,onMouseMove:this.state.dragging?this.swipeMove:null,onMouseUp:this.swipeEnd,onMouseLeave:this.state.dragging?this.swipeEnd:null,onTouchStart:this.swipeStart,onTouchMove:this.state.dragging?this.swipeMove:null,onTouchEnd:this.swipeEnd,onTouchCancel:this.state.dragging?this.swipeEnd:null},a["default"].createElement(g.Track,n({ref:"track"},i),this.props.children)),r,o,e)}});t.InnerSlider=y},704:function(e,t,i){"use strict";function s(e){return e&&e.__esModule?e:{"default":e}}Object.defineProperty(t,"__esModule",{value:!0});var n=i(705),r=i(707),a=(s(r),i(708)),o=s(a),l={changeSlide:function(e){var t,i,s,n,r;if(n=this.state.slideCount%this.props.slidesToScroll!==0,t=n?0:(this.state.slideCount-this.state.currentSlide)%this.props.slidesToScroll,"previous"===e.message)s=0===t?this.props.slidesToScroll:this.props.slidesToShow-t,r=this.state.currentSlide-s,this.props.lazyLoad&&(i=this.state.currentSlide-s,r=i===-1?this.state.slideCount-1:i);else if("next"===e.message)s=0===t?this.props.slidesToScroll:t,r=this.state.currentSlide+s;else if("dots"===e.message){if(r=e.index*e.slidesToScroll,r===e.currentSlide)return}else if("index"===e.message&&(r=e.index,r===e.currentSlide))return;this.slideHandler(r)},keyHandler:function(e){},selectHandler:function(e){},swipeStart:function(e){var t,i;this.props.swipe===!1||"ontouchend"in document&&this.props.swipe===!1||this.props.draggable===!1&&e.type.indexOf("mouse")!==-1||(t=void 0!==e.touches?e.touches[0].pageX:e.clientX,i=void 0!==e.touches?e.touches[0].pageY:e.clientY,this.setState({dragging:!0,touchObject:{startX:t,startY:i,curX:t,curY:i}}))},swipeMove:function(e){if(this.state.dragging&&!this.state.animating){var t,i,s,r=this.state.touchObject;i=(0,n.getTrackLeft)((0,o["default"])({slideIndex:this.state.currentSlide,trackRef:this.refs.track},this.props,this.state)),r.curX=e.touches?e.touches[0].pageX:e.clientX,r.curY=e.touches?e.touches[0].pageY:e.clientY,r.swipeLength=Math.round(Math.sqrt(Math.pow(r.curX-r.startX,2))),s=(this.props.rtl===!1?1:-1)*(r.curX>r.startX?1:-1);var a=this.state.currentSlide,l=Math.ceil(this.state.slideCount/this.props.slidesToScroll),d=this.swipeDirection(this.state.touchObject),c=r.swipeLength;this.props.infinite===!1&&(0===a&&"right"===d||a+1>=l&&"left"===d)&&(c=r.swipeLength*this.props.edgeFriction,this.state.edgeDragged===!1&&this.props.edgeEvent&&(this.props.edgeEvent(d),this.setState({edgeDragged:!0}))),this.state.swiped===!1&&this.props.swipeEvent&&(this.props.swipeEvent(d),this.setState({swiped:!0})),t=i+c*s,this.setState({touchObject:r,swipeLeft:t,trackStyle:(0,n.getTrackCSS)((0,o["default"])({left:t},this.props,this.state))}),Math.abs(r.curX-r.startX)<.8*Math.abs(r.curY-r.startY)||r.swipeLength>4&&e.preventDefault()}},swipeEnd:function(e){if(this.state.dragging){var t=this.state.touchObject,i=this.state.listWidth/this.props.touchThreshold,s=this.swipeDirection(t);if(this.setState({dragging:!1,edgeDragged:!1,swiped:!1,swipeLeft:null,touchObject:{}}),t.swipeLength)if(t.swipeLength>i)e.preventDefault(),"left"===s?this.slideHandler(this.state.currentSlide+this.props.slidesToScroll):"right"===s?this.slideHandler(this.state.currentSlide-this.props.slidesToScroll):this.slideHandler(this.state.currentSlide);else{var r=(0,n.getTrackLeft)((0,o["default"])({slideIndex:this.state.currentSlide,trackRef:this.refs.track},this.props,this.state));this.setState({trackStyle:(0,n.getTrackAnimateCSS)((0,o["default"])({left:r},this.props,this.state))})}}},onInnerSliderEnter:function(e){this.props.autoplay&&this.props.pauseOnHover&&this.pause()},onInnerSliderLeave:function(e){this.props.autoplay&&this.props.pauseOnHover&&this.autoPlay()}};t["default"]=l,e.exports=t["default"]},705:function(e,t,i){"use strict";function s(e){return e&&e.__esModule?e:{"default":e}}Object.defineProperty(t,"__esModule",{value:!0});var n=i(706),r=s(n),a=function(e,t){return t.reduce(function(t,i){return t&&e.hasOwnProperty(i)},!0)?null:console.error("Keys Missing",e)},o=function(e){a(e,["left","variableWidth","slideCount","slidesToShow","slideWidth"]);var t;t=e.variableWidth?(e.slideCount+2*e.slidesToShow)*e.slideWidth:e.centerMode?(e.slideCount+2*(e.slidesToShow+1))*e.slideWidth:(e.slideCount+2*e.slidesToShow)*e.slideWidth;var i={opacity:1,width:t,WebkitTransform:"translate3d("+e.left+"px, 0px, 0px)",transform:"translate3d("+e.left+"px, 0px, 0px)",transition:"",WebkitTransition:"",msTransform:"translateX("+e.left+"px)"};return!window.addEventListener&&window.attachEvent&&(i.marginLeft=e.left+"px"),i};t.getTrackCSS=o;var l=function(e){a(e,["left","variableWidth","slideCount","slidesToShow","slideWidth","speed","cssEase"]);var t=o(e);return t.WebkitTransition="-webkit-transform "+e.speed+"ms "+e.cssEase,t.transition="transform "+e.speed+"ms "+e.cssEase,t};t.getTrackAnimateCSS=l;var d=function(e){a(e,["slideIndex","trackRef","infinite","centerMode","slideCount","slidesToShow","slidesToScroll","slideWidth","listWidth","variableWidth"]);var t,i,s=0;if(e.fade)return 0;if(e.infinite&&(e.slideCount>e.slidesToShow&&(s=e.slideWidth*e.slidesToShow*-1),e.slideCount%e.slidesToScroll!==0&&e.slideIndex+e.slidesToScroll>e.slideCount&&e.slideCount>e.slidesToShow&&(s=e.slideIndex>e.slideCount?(e.slidesToShow-(e.slideIndex-e.slideCount))*e.slideWidth*-1:e.slideCount%e.slidesToScroll*e.slideWidth*-1)),e.centerMode&&(e.infinite?s+=e.slideWidth*Math.floor(e.slidesToShow/2):s=e.slideWidth*Math.floor(e.slidesToShow/2)),t=e.slideIndex*e.slideWidth*-1+s,e.variableWidth===!0){var n;e.slideCount<=e.slidesToShow||e.infinite===!1?i=r["default"].findDOMNode(e.trackRef).childNodes[e.slideIndex]:(n=e.slideIndex+e.slidesToShow,i=r["default"].findDOMNode(e.trackRef).childNodes[n]),t=i?i.offsetLeft*-1:0,e.centerMode===!0&&(i=e.infinite===!1?r["default"].findDOMNode(e.trackRef).children[e.slideIndex]:r["default"].findDOMNode(e.trackRef).children[e.slideIndex+e.slidesToShow+1],t=i?i.offsetLeft*-1:0,t+=(e.listWidth-i.offsetWidth)/2)}return t};t.getTrackLeft=d},706:function(e,t,i){"use strict";function s(e){return e&&e.__esModule?e:{"default":e}}Object.defineProperty(t,"__esModule",{value:!0});var n=i(229),r=s(n),a=i(388),o=s(a),l=r["default"].version>="0.14.0"?o["default"]:r["default"];t["default"]=l,e.exports=t["default"]},707:function(e,t,i){"use strict";function s(e){return e&&e.__esModule?e:{"default":e}}Object.defineProperty(t,"__esModule",{value:!0});var n=i(229),r=s(n),a=i(706),o=s(a),l=i(696),d=s(l),c=i(705),u=i(708),h=s(u),p={initialize:function(e){var t=r["default"].Children.count(e.children),i=this.getWidth(o["default"].findDOMNode(this.refs.list)),s=this.getWidth(o["default"].findDOMNode(this.refs.track)),n=this.getWidth(o["default"].findDOMNode(this))/e.slidesToShow,a=e.rtl?t-1-e.initialSlide:e.initialSlide;this.setState({slideCount:t,slideWidth:n,listWidth:i,trackWidth:s,currentSlide:a},function(){var t=(0,c.getTrackLeft)((0,h["default"])({slideIndex:this.state.currentSlide,trackRef:this.refs.track},e,this.state)),i=(0,c.getTrackCSS)((0,h["default"])({left:t},e,this.state));this.setState({trackStyle:i}),this.autoPlay()})},update:function(e){var t=r["default"].Children.count(e.children),i=this.getWidth(o["default"].findDOMNode(this.refs.list)),s=this.getWidth(o["default"].findDOMNode(this.refs.track)),n=this.getWidth(o["default"].findDOMNode(this))/e.slidesToShow;this.setState({slideCount:t,slideWidth:n,listWidth:i,trackWidth:s},function(){var t=(0,c.getTrackLeft)((0,h["default"])({slideIndex:this.state.currentSlide,trackRef:this.refs.track},e,this.state)),i=(0,c.getTrackCSS)((0,h["default"])({left:t},e,this.state));this.setState({trackStyle:i})})},getWidth:function(e){return e.getBoundingClientRect().width||e.offsetWidth},adaptHeight:function(){if(this.props.adaptiveHeight){var e='[data-index="'+this.state.currentSlide+'"]';if(this.refs.list){var t=o["default"].findDOMNode(this.refs.list);t.style.height=t.querySelector(e).offsetHeight+"px"}}},slideHandler:function(e){var t,i,s,n,r,a=this;if(!(this.props.waitForAnimate&&this.state.animating||this.state.currentSlide===e)){if(this.props.fade)return i=this.state.currentSlide,t=e<0?e+this.state.slideCount:e>=this.state.slideCount?e-this.state.slideCount:e,this.props.lazyLoad&&this.state.lazyLoadedList.indexOf(t)<0&&this.setState({lazyLoadedList:this.state.lazyLoadedList.concat(t)}),r=function(){a.setState({animating:!1}),a.props.afterChange&&a.props.afterChange(i),d["default"].removeEndEventListener(o["default"].findDOMNode(a.refs.track).children[i],r)},this.setState({animating:!0,currentSlide:t},function(){d["default"].addEndEventListener(o["default"].findDOMNode(this.refs.track).children[i],r)}),this.props.beforeChange&&this.props.beforeChange(this.state.currentSlide,i),void this.autoPlay();if(t=e,i=t<0?this.props.infinite===!1?0:this.state.slideCount%this.props.slidesToScroll!==0?this.state.slideCount-this.state.slideCount%this.props.slidesToScroll:this.state.slideCount+t:t>=this.state.slideCount?this.props.infinite===!1?this.state.slideCount-this.props.slidesToShow:this.state.slideCount%this.props.slidesToScroll!==0?0:t-this.state.slideCount:t,s=(0,c.getTrackLeft)((0,h["default"])({slideIndex:t,trackRef:this.refs.track},this.props,this.state)),n=(0,c.getTrackLeft)((0,h["default"])({slideIndex:i,trackRef:this.refs.track},this.props,this.state)),this.props.infinite===!1&&(s=n),this.props.beforeChange&&this.props.beforeChange(this.state.currentSlide,i),this.props.lazyLoad){for(var l=!0,u=[],p=t;p<t+this.props.slidesToShow;p++)l=l&&this.state.lazyLoadedList.indexOf(p)>=0,l||u.push(p);l||this.setState({lazyLoadedList:this.state.lazyLoadedList.concat(u)})}if(this.props.useCSS===!1)this.setState({currentSlide:i,trackStyle:(0,c.getTrackCSS)((0,h["default"])({left:n},this.props,this.state))},function(){this.props.afterChange&&this.props.afterChange(i)});else{var f={animating:!1,currentSlide:i,trackStyle:(0,c.getTrackCSS)((0,h["default"])({left:n},this.props,this.state)),swipeLeft:null};r=function(){a.setState(f),a.props.afterChange&&a.props.afterChange(i),d["default"].removeEndEventListener(o["default"].findDOMNode(a.refs.track),r)},this.setState({animating:!0,currentSlide:i,trackStyle:(0,c.getTrackAnimateCSS)((0,h["default"])({left:s},this.props,this.state))},function(){d["default"].addEndEventListener(o["default"].findDOMNode(this.refs.track),r)})}this.state.autoPlayTimer||this.autoPlay()}},swipeDirection:function(e){var t,i,s,n;return t=e.startX-e.curX,i=e.startY-e.curY,s=Math.atan2(i,t),n=Math.round(180*s/Math.PI),n<0&&(n=360-Math.abs(n)),n<=45&&n>=0||n<=360&&n>=315?this.props.rtl===!1?"left":"right":n>=135&&n<=225?this.props.rtl===!1?"right":"left":"vertical"},autoPlay:function(){var e=this,t=function(){if(e.state.mounted){var t=e.props.rtl?e.state.currentSlide-e.props.slidesToScroll:e.state.currentSlide+e.props.slidesToScroll;e.slideHandler(t)}};this.props.autoplay&&this.setState({autoPlayTimer:window.setInterval(t,this.props.autoplaySpeed)})},pause:function(){this.state.autoPlayTimer&&window.clearInterval(this.state.autoPlayTimer)}};t["default"]=p,e.exports=t["default"]},708:function(e,t){"use strict";function i(e){if(null==e)throw new TypeError("Object.assign cannot be called with null or undefined");return Object(e)}e.exports=Object.assign||function(e,t){for(var s,n,r=i(e),a=1;a<arguments.length;a++){s=arguments[a],n=Object.keys(Object(s));for(var o=0;o<n.length;o++)r[n[o]]=s[n[o]]}return r}},709:function(e,t){"use strict";var i={animating:!1,dragging:!1,autoPlayTimer:null,currentDirection:0,currentLeft:null,currentSlide:0,direction:1,slideCount:null,slideWidth:null,swipeLeft:null,touchObject:{startX:0,startY:0,curX:0,curY:0},lazyLoadedList:[],initialized:!1,edgeDragged:!1,swiped:!1,trackStyle:{},trackWidth:0};e.exports=i},710:function(e,t){"use strict";var i={className:"",adaptiveHeight:!1,arrows:!0,autoplay:!1,autoplaySpeed:3e3,centerMode:!1,centerPadding:"50px",cssEase:"ease",dots:!1,dotsClass:"slick-dots",draggable:!0,easing:"linear",edgeFriction:.35,fade:!1,focusOnSelect:!1,infinite:!0,initialSlide:0,lazyLoad:!1,pauseOnHover:!1,responsive:null,rtl:!1,slide:"div",slidesToShow:1,slidesToScroll:1,speed:500,swipe:!0,swipeToSlide:!1,touchMove:!0,touchThreshold:5,useCSS:!0,variableWidth:!1,vertical:!1,waitForAnimate:!0,afterChange:null,beforeChange:null,edgeEvent:null,init:null,swipeEvent:null,nextArrow:null,prevArrow:null};e.exports=i},711:function(e,t,i){"use strict";function s(e){return e&&e.__esModule?e:{"default":e}}Object.defineProperty(t,"__esModule",{value:!0});var n=i(229),r=s(n),a=i(708),o=s(a),l=i(386),d=s(l),c=function(e){var t,i,s,n,r;return r=e.rtl?e.slideCount-1-e.index:e.index,s=r<0||r>=e.slideCount,e.centerMode?(n=Math.floor(e.slidesToShow/2),i=(r-e.currentSlide)%e.slideCount===0,r>e.currentSlide-n-1&&r<=e.currentSlide+n&&(t=!0)):t=e.currentSlide<=r&&r<e.currentSlide+e.slidesToShow,(0,d["default"])({"slick-slide":!0,"slick-active":t,"slick-center":i,"slick-cloned":s})},u=function(e){var t={};return void 0!==e.variableWidth&&e.variableWidth!==!1||(t.width=e.slideWidth),e.fade&&(t.position="relative",t.left=-e.index*e.slideWidth,t.opacity=e.currentSlide===e.index?1:0,t.transition="opacity "+e.speed+"ms "+e.cssEase,t.WebkitTransition="opacity "+e.speed+"ms "+e.cssEase),t},h=function(e){var t,i,s=[],n=[],a=[],l=r["default"].Children.count(e.children);return r["default"].Children.forEach(e.children,function(h,p){i=!e.lazyLoad|(e.lazyLoad&&e.lazyLoadedList.indexOf(p)>=0)?h:r["default"].createElement("div",null);var f,m=u((0,o["default"])({},e,{index:p})),v=c((0,o["default"])({index:p},e));if(f=i.props.className?(0,d["default"])(v,i.props.className):v,s.push(r["default"].cloneElement(i,{key:p,"data-index":p,className:f,style:(0,o["default"])({},i.props.style||{},m)})),e.infinite&&e.fade===!1){var g=e.variableWidth?e.slidesToShow+1:e.slidesToShow;p>=l-g&&(t=-(l-p),n.push(r["default"].cloneElement(i,{key:t,"data-index":t,className:c((0,o["default"])({index:t},e)),style:(0,o["default"])({},i.props.style||{},m)}))),p<g&&(t=l+p,a.push(r["default"].cloneElement(i,{key:t,"data-index":t,className:c((0,o["default"])({index:t},e)),style:(0,o["default"])({},i.props.style||{},m)})))}}),e.rtl?n.concat(s,a).reverse():n.concat(s,a)},p=r["default"].createClass({displayName:"Track",render:function(){var e=h(this.props);return r["default"].createElement("div",{className:"slick-track",style:this.props.trackStyle},e)}});t.Track=p},712:function(e,t,i){"use strict";function s(e){return e&&e.__esModule?e:{"default":e}}Object.defineProperty(t,"__esModule",{value:!0});var n=i(229),r=s(n),a=i(386),o=s(a),l=function(e){var t;return t=Math.ceil(e.slideCount/e.slidesToScroll)},d=r["default"].createClass({displayName:"Dots",clickHandler:function(e,t){t.preventDefault(),this.props.clickHandler(e)},render:function(){var e=this,t=l({slideCount:this.props.slideCount,slidesToScroll:this.props.slidesToScroll}),i=Array.apply(null,Array(t+1).join("0").split("")).map(function(t,i){var s=(0,o["default"])({"slick-active":e.props.currentSlide===i*e.props.slidesToScroll}),n={message:"dots",index:i,slidesToScroll:e.props.slidesToScroll,currentSlide:e.props.currentSlide};return r["default"].createElement("li",{key:i,className:s},r["default"].createElement("button",{onClick:e.clickHandler.bind(e,n)},i+1))});return r["default"].createElement("ul",{className:this.props.dotsClass,style:{display:"block"}},i)}});t.Dots=d},713:function(e,t,i){"use strict";function s(e){return e&&e.__esModule?e:{"default":e}}Object.defineProperty(t,"__esModule",{value:!0});var n=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var i=arguments[t];for(var s in i)Object.prototype.hasOwnProperty.call(i,s)&&(e[s]=i[s])}return e},r=i(229),a=s(r),o=i(386),l=s(o),d=a["default"].createClass({displayName:"PrevArrow",clickHandler:function(e,t){t.preventDefault(),this.props.clickHandler(e,t)},render:function(){var e={"slick-prev":!0},t=this.clickHandler.bind(this,{message:"previous"});!this.props.infinite&&(0===this.props.currentSlide||this.props.slideCount<=this.props.slidesToShow)&&(e["slick-disabled"]=!0,t=null);var i,s={key:"0",ref:"previous","data-role":"none",className:(0,l["default"])(e),style:{display:"block"},onClick:t};return i=this.props.prevArrow?a["default"].createElement(this.props.prevArrow,s):a["default"].createElement("button",n({key:"0",type:"button"},s)," Previous")}});t.PrevArrow=d;var c=a["default"].createClass({displayName:"NextArrow",clickHandler:function(e,t){t.preventDefault(),this.props.clickHandler(e,t)},render:function(){var e={"slick-next":!0},t=this.clickHandler.bind(this,{message:"next"});this.props.infinite||(this.props.centerMode&&this.props.currentSlide>=this.props.slideCount-1?(e["slick-disabled"]=!0,t=null):this.props.currentSlide>=this.props.slideCount-this.props.slidesToShow&&(e["slick-disabled"]=!0,t=null),this.props.slideCount<=this.props.slidesToShow&&(e["slick-disabled"]=!0,t=null));var i,s={key:"1",ref:"next","data-role":"none",className:(0,l["default"])(e),style:{display:"block"},onClick:t};return i=this.props.nextArrow?a["default"].createElement(this.props.nextArrow,s):a["default"].createElement("button",n({key:"1",type:"button"},s)," Next")}});t.NextArrow=c},714:function(e,t,i){var s=i(715),n=function(e){var t=/[height|width]$/;return t.test(e)},r=function(e){var t="",i=Object.keys(e);return i.forEach(function(r,a){var o=e[r];r=s(r),n(r)&&"number"==typeof o&&(o+="px"),t+=o===!0?r:o===!1?"not "+r:"("+r+": "+o+")",a<i.length-1&&(t+=" and ")}),t},a=function(e){var t="";return"string"==typeof e?e:e instanceof Array?(e.forEach(function(i,s){t+=r(i),s<e.length-1&&(t+=", ")}),t):r(e)};e.exports=a},715:function(e,t){var i=function(e){return e.replace(/[A-Z]/g,function(e){return"-"+e.toLowerCase()}).toLowerCase()};e.exports=i},716:function(e,t,i){var s=i(717),n=s&&i(718),r=i(714),a={media:function(e,t){e=r(e),"function"==typeof t&&(t={match:t}),n.register(e,t),this._responsiveMediaHandlers||(this._responsiveMediaHandlers=[]),this._responsiveMediaHandlers.push({query:e,handler:t})},componentWillUnmount:function(){this._responsiveMediaHandlers&&this._responsiveMediaHandlers.forEach(function(e){n.unregister(e.query,e.handler)})}};e.exports=a},717:function(e,t){var i=!("undefined"==typeof window||!window.document||!window.document.createElement);e.exports=i},718:function(e,t,i){var s=i(719);e.exports=new s},719:function(e,t,i){function s(){if(!window.matchMedia)throw new Error("matchMedia not present, legacy browsers require a polyfill");this.queries={},this.browserIsIncapable=!window.matchMedia("only all").matches}var n=i(720),r=i(722),a=r.each,o=r.isFunction,l=r.isArray;s.prototype={constructor:s,register:function(e,t,i){var s=this.queries,r=i&&this.browserIsIncapable;return s[e]||(s[e]=new n(e,r)),o(t)&&(t={match:t}),l(t)||(t=[t]),a(t,function(t){o(t)&&(t={match:t}),s[e].addHandler(t)}),this},unregister:function(e,t){var i=this.queries[e];return i&&(t?i.removeHandler(t):(i.clear(),delete this.queries[e])),this}},e.exports=s},720:function(e,t,i){function s(e,t){this.query=e,this.isUnconditional=t,this.handlers=[],this.mql=window.matchMedia(e);var i=this;this.listener=function(e){i.mql=e.currentTarget||e,i.assess()},this.mql.addListener(this.listener)}var n=i(721),r=i(722).each;s.prototype={constuctor:s,addHandler:function(e){var t=new n(e);this.handlers.push(t),this.matches()&&t.on()},removeHandler:function(e){var t=this.handlers;r(t,function(i,s){if(i.equals(e))return i.destroy(),!t.splice(s,1)})},matches:function(){return this.mql.matches||this.isUnconditional},clear:function(){r(this.handlers,function(e){e.destroy()}),this.mql.removeListener(this.listener),this.handlers.length=0},assess:function(){var e=this.matches()?"on":"off";r(this.handlers,function(t){t[e]()})}},e.exports=s},721:function(e,t){function i(e){this.options=e,!e.deferSetup&&this.setup()}i.prototype={constructor:i,setup:function(){this.options.setup&&this.options.setup(),this.initialised=!0},on:function(){!this.initialised&&this.setup(),this.options.match&&this.options.match()},off:function(){this.options.unmatch&&this.options.unmatch()},destroy:function(){this.options.destroy?this.options.destroy():this.off()},equals:function(e){return this.options===e||this.options.match===e}},e.exports=i},722:function(e,t){function i(e,t){var i,s=0,n=e.length;for(s;s<n&&(i=t(e[s],s),i!==!1);s++);}function s(e){return"[object Array]"===Object.prototype.toString.apply(e)}function n(e){return"function"==typeof e}e.exports={isFunction:n,isArray:s,each:i}},723:function(e,t,i){"use strict";var s=(i(143),i(229)),n=(i(590),s.createClass({displayName:"ImagePlaceholder",propTypes:{src:s.PropTypes.string,placeholder:s.PropTypes.string,errorSrc:s.PropTypes.string,className:s.PropTypes.string},getDefaultProps:function(){return{src:"",placeholder:"",errorSrc:"",className:""}},getInitialState:function(){return{success:!1,error:!1}},updateSource:function(){var e=this,t=this.props.src;this._image.onload=function(){e.isMounted()&&(e.setState({success:!0}),e._image.onload=null)},this._image.onerror=function(t){e.isMounted()&&(e.setState({error:!0}),e._image.onerror=null)},this._image.src=t},componentWillMount:function(){this._image=new Image},componentDidMount:function(){this.updateSource()},componentDidUpdate:function(e,t){e.src!==this.props.src&&this.updateSource()},render:function(){var e,t=this.props.className,i=this.props.placeholder;return e=this.state.success?this.props.src:this.state.error&&this.props.errorSrc?this.props.errorSrc:i,s.createElement("div",{className:t,style:{backgroundSize:"100%",backgroundImage:"url("+i+")"}},s.createElement("img",{src:e,style:{width:"100%",WebkitTransition:"all 1.2s ease",opacity:this.state.success?1:.01}}))}}));e.exports=n},724:function(e,t,i){e.exports=i.p+"asset/1598cc489be15707b86e501996a81c6d.png"},725:function(e,t,i){"use strict";var s=i(229),n=(i(438),i(215),i(226).redirect),r=(i(726),i(723)),a=i(591),o=i(592).StoreWatchMixin,l=i(728),d=s.createClass({displayName:"FilmItem",handleClick:function(){n("#!/film/"+this.props.film.get("id"))},render:function(){var e=this.props.film.attributes;return s.createElement("li",null,s.createElement("div",{className:"movie-item",onClick:this.handleClick},s.createElement("div",{className:"movie-item-img"},s.createElement(r,{className:"img-responsive",src:e.cover.horizontalLogo||e.cover.origin,placeholder:i(729)})),s.createElement("div",{className:"row desc"},s.createElement("div",{className:"col-xs-10 left"},s.createElement("div",{className:"film-name"},e.name),s.createElement("div",{className:"count"},e.cinemaCount,"家影院上映 ",e.watchCount,"人购票")),s.createElement("div",{className:"col-xs-2 right"},s.createElement("span",{className:"score"},e.grade)))))}}),c=s.createClass({displayName:"NowPlayingFilmList",mixins:[a,o("FilmStore")],getMore:function(){n("#!/film")},getStateFromFlux:function(){return{films:this.getFlux().store("FilmStore").getNowPlayingFilms()}},componentDidMount:function(){this.getFlux().actions.film.patchNowPlaying({count:5})},render:function(){var e=this.state.films.map(function(e){return s.createElement(d,{key:e.get("id"),film:e})});return s.createElement("div",null,s.createElement("div",{className:"movie"},s.createElement("ul",{className:"list-unstyled"},e)),s.createElement(l,{onClick:this.getMore},"更多热映电影"))}});e.exports=c},728:function(e,t,i){"use strict";var s=i(229),n=s.createClass({displayName:"MoreButton",handleClick:function(){this.props.onClick()},render:function(){return s.createElement("div",{className:"more-button",onClick:this.handleClick},this.props.children)}});e.exports=n},729:function(e,t,i){e.exports=i.p+"asset/3d2cdb3bd9a23609aa2d84e7c2bfd035.png"},730:function(e,t,i){"use strict";var s=i(229),n=i(438),r=(i(215),i(226).redirect),a=(i(726),i(590),i(723)),o=i(591),l=i(592).StoreWatchMixin,d=i(728),c=s.createClass({displayName:"FilmItem",handleClick:function(){r("#!/film/"+this.props.film.get("id"))},render:function(){var e=this.props.film.attributes,t=e.isPresold?s.createElement("div",{className:"movie-item-img"},s.createElement("img",{className:"presold-tip",src:i(731)}),s.createElement(a,{className:"img-responsive",src:e.cover.origin||e.poster.origin,placeholder:i(729)})):s.createElement("div",{className:"movie-item-img"},s.createElement(a,{className:"img-responsive",src:e.cover.origin||e.poster.origin,placeholder:i(729)}));return s.createElement("li",null,s.createElement("div",{className:"movie-item",onClick:this.handleClick},t,s.createElement("div",{className:"row upcoming-desc"},s.createElement("div",{className:"col-xs-7 left"},s.createElement("div",{className:"film-name"},e.name)),s.createElement("div",{className:"col-xs-5 right"},s.createElement("div",{className:"showing-date"},n(+e.premiereAt).format("M月D日上映"))))))}}),u=s.createClass({displayName:"ComingSoonFilmList",mixins:[o,l("FilmStore")],getMore:function(){r("#!/film/coming-soon")},getStateFromFlux:function(){return{films:this.getFlux().store("FilmStore").getComingSoonFilms()}},componentDidMount:function(){this.getFlux().actions.film.patchComingSoon()},render:function(){var e=this.state.films.map(function(e){return s.createElement(c,{key:e.get("id"),film:e})});return s.createElement("div",null,s.createElement("div",{className:"dividing-line"},s.createElement("div",{className:"upcoming"},"即将上映")),s.createElement("div",{className:"movie"},s.createElement("ul",{className:"list-unstyled"},e)),s.createElement(d,{onClick:this.getMore},"更多即将上映电影"))}});e.exports=u},731:function(e,t,i){e.exports=i.p+"asset/cb9f9bddb7b5c71087bcbf6779fe887f.png"},732:function(e,t,i){"use strict";var s=(i(143),i(229)),n=i(590),r=i(733),a=120,o=new r($(window).get(0)),l=s.createClass({displayName:"BackToTop",propTypes:{},getDefaultProps:function(){return{}},getInitialState:function(){return{show:!1}},handleClick:function(){$("body").animate({scrollTop:0},400)},componentDidMount:function(){var e=this;o.addListener(function(){e.isMounted()&&e.setState({show:$("body").scrollTop()>a})})},render:function(){return s.createElement("div",{className:"cpn-back-to-top "+(this.props.className||"")+(this.state.show?"":" cpn-back-to-top-hide"),onClick:this.handleClick},s.createElement("div",{className:"circle"},s.createElement(n,null,"top")))}});e.exports=l},733:function(e,t){"use strict";e.exports=function(e,t,i){var s=[],n=function(i){
var n,r=this;return r.element=i,n=function(){var i,s=t.createEvent("Event");s.initEvent("scroll",!0,!0);var n=function(){r.element.dispatchEvent(s)},a=function(){i=setInterval(n,20)},o=function(){clearInterval(i)};"ontouchstart"in e&&(r.element.addEventListener("touchstart",a),r.element.addEventListener("touchmove",n),r.element.addEventListener("touchend",o))},s.indexOf(r.element)===-1&&(s.push(r.element),n()),r};return n.prototype.addListener=function(e){this.element.addEventListener("scroll",e)},n.prototype.removeListener=function(e){this.element.removeEventListener("scroll",e)},n.prototype.dispatch=function(){var e=t.createEvent("Event");e.initEvent("scroll",!0,!0),this.element.dispatchEvent(e)},n}(window,document,_)}});