function ImagePreloader(images, callback, idCat) {
//  images = "";
   this.img = images;
   this.idCat = idCat;
   // store the call-back
   this.callback = callback;
   // initialize internal state.
   this.nLoaded = 0;
   this.nProcessed = 0;
   this.aImages = new Array;
   // record the number of images.
   this.nImages = images.length;
   // for each image, call preload()
   for ( var i = 0; i < images.length; i++ )
      this.preload(images[i], i, this.idCat);
      	//alert(this.bError)
}

ImagePreloader.prototype.preload =  function(image, cont, idCat) {
   // create new Image object and add to array
   var oImage = new Image;
   this.aImages.push(oImage);
   // set up event handlers for the Image object
   oImage.onload = ImagePreloader.prototype.onload;
//   oImage.onerror = ImagePreloader.prototype.onerror;
   oImage.onerror = function() {
  // 	alert(imgPre[idCat][cont]);
	   try {
//	   	   imgPre[idCat][cont] = "/tapas/adicionales/sinImagen_" + idCat + ".jpg";
			if (imgPre[idCat][cont] == oImage.src) {
				imgPre[idCat][cont] = "/tapas/adicionales/sinImagen_" + idCat + ".jpg";
			}
			if (imgPreSig[idCat][cont] == oImage.src) {
				imgPreSig[idCat][cont] = "/tapas/adicionales/sinImagen_" + idCat + ".jpg";
			}
		/*	if (imgPreAnt[idCat][cont] == oImage.src) {
				imgPreAnt[idCat][cont] = "/tapas/adicionales/sinImagen_" + idCat + ".jpg";
			}*/
   	    } catch (e) {
	    }
    	this.bError = true;
		this.oImagePreloader.onComplete();
   };
   oImage.onabort = ImagePreloader.prototype.onabort;
   // assign pointer back to this.
   oImage.oImagePreloader = this;
   oImage.bLoaded = false;
   oImage.bError= false;
   // assign the .src property of the Image object
   oImage.src = image;
}

ImagePreloader.prototype.onComplete =  function(){
   this.nProcessed++;
   if ( this.nProcessed == this.nImages )  {
      //this.callback(this.aImages, this.nLoaded);
      this.callback(this.idCat);
   }
}

ImagePreloader.prototype.onload =  function() {
   this.bLoaded = true;
   this.oImagePreloader.nLoaded++;
   this.oImagePreloader.onComplete();
}

/*
ImagePreloader.prototype.onerror =  function() {
   alert(cont)
   this.bError = true;
   this.oImagePreloader.onComplete();
}*/

ImagePreloader.prototype.onabort =  function() {
   this.bAbort = true;
   this.oImagePreloader.onComplete();
}





