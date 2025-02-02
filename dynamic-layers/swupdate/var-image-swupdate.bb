# Copyright (C) 2017 Variscite Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Variscite Image to validate i.MX machines. \
This image contains everything used to test i.MX machines including GUI, \
demos and lots of applications. This creates a very large image, not \
suitable for production."
LICENSE = "MIT"

SWUPDATE_BASE_IMAGE = "${@bb.utils.contains('DISTRO', 'b2qt', 'recipes-qt/images/b2qt-embedded-qt6-image.bb', 'recipes-fsl/images/fsl-image-gui.bb', d)}"
require ${SWUPDATE_BASE_IMAGE}

### WARNING: This image is NOT suitable for production use and is intended
###          to provide a way for users to reproduce the image used during
###          the validation process of i.MX BSP releases.

CORE_IMAGE_EXTRA_INSTALL += " \
	swupdate \
	swupdate-www \
	kernel-image \
	kernel-devicetree \
"

QBSP_IMAGE_CONTENT = ""
IMAGE_FSTYPES = "tar.gz"
