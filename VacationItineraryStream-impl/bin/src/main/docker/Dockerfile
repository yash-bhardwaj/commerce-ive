FROM java:8

MAINTAINER slu@rccl.com

ENV APP_DIRECTORY /usr/src/app/commerce-ive
ENV APP_LIB_DIR /usr/src/app/commerce-ive/lib/

RUN echo "Creating APP Directory $APP_DIRECTORY"
RUN mkdir -p $APP_DIRECTORY

RUN echo "Creating APP Library Directory $APP_LIB_DIR"
RUN mkdir -p $APP_LIB_DIR

RUN echo "Copying jars to  APP Library Directory $APP_LIB_DIR"
COPY ./maven/* $APP_LIB_DIR

RUN echo "Adding entryPoint.sh"
ADD ./maven/bin/entryPoint.sh /entryPoint.sh

EXPOSE 9001

ENTRYPOINT ["/entryPoint.sh","$APP_DIRECTORY","$APP_LIB_DIR"]
