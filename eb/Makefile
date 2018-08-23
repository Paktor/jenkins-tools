build:
	docker build -t jenkinstools/eb:latest .

push:
	docker push jenkinstools/eb:latest

version:
	docker run -it --rm -u 1000:1000 -v /var/run/docker.sock:/var/run/docker.sock jenkinstools/eb:latest eb --version

