import React, { useState, useCallback } from 'react';
import { render } from 'react-dom';
import ImageViewer from 'react-simple-image-viewer';

function Example(imageList) {
  const [currentImage, setCurrentImage] = useState(0);
  const [isViewerOpen, setIsViewerOpen] = useState(false);
//  const images = [
//    'http://localhost:8080/caching.jpg',
//    'http://localhost:8080/proxy.jpg',
//    'http://localhost:8080/dataPartition.jpg',
//  ];


//a bongeszo console logban miert irja ki 2 ???????????????
//mert react strict mode
//  var images = Object.values(imageList);
  console.log("imageList.input : " + imageList.input);
  //object
  console.log("imagesList : " + imageList);

  // itt valamihogy array-t kene masolni, const images lehet h string
  const images = Object.values(imageList);

  images.forEach(function(entry) {
    console.log(entry);
  });

  const openImageViewer = useCallback((index) => {
    setCurrentImage(index);
    setIsViewerOpen(true);
  }, []);

  const closeImageViewer = () => {
    setCurrentImage(0);
    setIsViewerOpen(false);
  };

  return (
    <div>
      {images.map((src, index) => (
        <img
          src={ src }
          onClick={ () => openImageViewer(index) }
          width="300"
          key={ index }
          style={{ margin: '2px' }}
          alt=""
        />
      ))}

      {isViewerOpen && (
        <ImageViewer
          src={ images }
          currentIndex={ currentImage }
          disableScroll={ false }
          closeOnClickOutside={ true }
          onClose={ closeImageViewer }
        />
      )}
    </div>
  );
}


export default Example;