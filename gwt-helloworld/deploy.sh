#!/usr/bin/env bash
../gradlew gwtCompile
aws s3 sync build/putnami/out/ s3://staging-puudata.zaoo.com/gwt/ --include "*" --exclude "*.nocache.js" --exclude "*.devmode.js" --exclude ".DS_Store" --region us-west-2 --acl public-read --cache-control 'max-age=31536000'
# using cp here because sync sometimes skips uploading changed nocache file
aws s3 cp build/putnami/out/ s3://staging-puudata.zaoo.com/gwt/ --recursive --exclude "*" --include "*.nocache.js" --region us-west-2 --acl public-read --cache-control 'no-cache'
