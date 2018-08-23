build:
	docker build -t jenkinstools/base:latest .

push:
	docker push jenkinstools/base:latest

run:
	docker run -it --rm -u 1000:1000 -v /var/run/docker.sock:/var/run/docker.sock jenkinstools/base:latest

 