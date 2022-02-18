# node 이미지를 받는다 build이미지이구나 
# node 기반의 이미지로 생성된다. 
FROM node:lts-alpine as build-stage 
WORKDIR /app
ADD . .
RUN npm install
RUN npm run build

FROM nginx:stable-alpine as production-stage
COPY  ./nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=build-stage /app/dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]